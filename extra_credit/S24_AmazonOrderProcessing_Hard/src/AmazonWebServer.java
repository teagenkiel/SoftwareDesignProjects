import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 *
 *
 *
 *
 */
public class AmazonWebServer implements Runnable{

    private final ArrayBlockingQueue<Order> webServerOutput1;
    private final ArrayBlockingQueue<Order> webServerOutput2;
    private final ExecutorService threadExecutor;
    private final Scanner scanner;

    public static final int MAX_BUFFER_SIZE = 20;


    public AmazonWebServer(String fileName) throws FileNotFoundException {

        this.webServerOutput1 = new ArrayBlockingQueue<Order>(MAX_BUFFER_SIZE);
        this.webServerOutput2 = new ArrayBlockingQueue<Order>(MAX_BUFFER_SIZE);

        this.threadExecutor = Executors.newCachedThreadPool();

        InputStream inputStream = AmazonWebServer.class.getResourceAsStream(fileName);
        this.scanner = new Scanner(inputStream);
        //scanner.useDelimiter(",");
    }


    @Override
    public void run() {

        int orderNumberCounter = 1; //first order will be order # 1

        ShippingCenter shippingCenter1 = new ShippingCenter(webServerOutput1);
        ShippingCenter shippingCenter2 = new ShippingCenter(webServerOutput2);

        threadExecutor.execute(shippingCenter1);
        threadExecutor.execute(shippingCenter2);
        threadExecutor.shutdown();


        while(scanner.hasNext()){

            String currentOrder = scanner.nextLine();
            String[] currentOrderArray = currentOrder.split(","); //split up each cell, separated by ','

            Order newOrder = new Order(orderNumberCounter, currentOrderArray[0], currentOrderArray[1], currentOrderArray[2],
                    currentOrderArray[3], currentOrderArray[4], currentOrderArray[5], currentOrderArray[6]);
            //give each split cell to the Order constructor in order

            System.out.println("Created new Order: " + newOrder + "\n");

            String city = newOrder.getCity();

            try {

                if (city.equals("Los Angeles") || city.equals("San Fransisco") || city.equals("Seattle")
                        || city.equals("Denver")){
                    newOrder.setShippingCenterNumber("1");
                    webServerOutput1.put(newOrder);
                }
                else {
                    newOrder.setShippingCenterNumber("2");
                    webServerOutput2.put(newOrder);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt(); //gives the interrupt to the current thread to handle
            }

            orderNumberCounter++;
        }

        //pass to the buffers that there are no more orders
        String noMoreOrders = "No more orders";
        Order terminatingOrder = new Order(-1, noMoreOrders, noMoreOrders, noMoreOrders, noMoreOrders, noMoreOrders,
                noMoreOrders, noMoreOrders);
        try {
            webServerOutput1.put(terminatingOrder);
            webServerOutput2.put(terminatingOrder);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
