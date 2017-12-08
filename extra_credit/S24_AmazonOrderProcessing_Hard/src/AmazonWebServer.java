import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.Scanner;

/**
 *
 *
 *
 *
 *
 */
public class AmazonWebServer implements Runnable{

    private final ArrayBlockingQueue<Order> webServerOutput;
    private final Scanner scanner;


    public AmazonWebServer(ArrayBlockingQueue<Order> webServerOutput, String fileName) throws FileNotFoundException {

        this.webServerOutput = webServerOutput;

        InputStream inputStream = AmazonWebServer.class.getResourceAsStream(fileName);
        this.scanner = new Scanner(inputStream);
        scanner.useDelimiter(",");
    }


    @Override
    public void run() {

        String readData;
        int orderNumberCounter = 1; //first order will be order # 1



        while(scanner.hasNext()){

            String currentOrder = scanner.nextLine();
            String[] currentOrderArray = currentOrder.split(","); //split up each cell, separated by ','

            Order newOrder = new Order(orderNumberCounter, currentOrderArray[0], currentOrderArray[1], currentOrderArray[2],
                    currentOrderArray[3], currentOrderArray[4], currentOrderArray[5], currentOrderArray[6]);
            //give each split cell to the Order constructor in order

            System.out.println("Created new Order: " + newOrder + "\n");



            try {
                webServerOutput.put(newOrder);
                System.out.println("Added new order to queue");
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt(); //gives the interrupt to the current thread to handle
            }



            orderNumberCounter++;
        }
    }
}
