import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 *
 *
 *
 *
 */
public class ShippingCenter implements Runnable {

    private ArrayBlockingQueue<Order> centerInputBuffer;
    private ArrayBlockingQueue<Order> section1InputBuffer;
    private ArrayBlockingQueue<Order> section2InputBuffer;
    private ExecutorService threadExecutor;

    public ShippingCenter(ArrayBlockingQueue centerInputBuffer){

        this.centerInputBuffer = centerInputBuffer;
        this.section1InputBuffer = new ArrayBlockingQueue<Order>(AmazonWebServer.MAX_BUFFER_SIZE);
        this.section2InputBuffer = new ArrayBlockingQueue<Order>(AmazonWebServer.MAX_BUFFER_SIZE);
        this.threadExecutor = Executors.newCachedThreadPool();
    }


    @Override
    public void run() {

        ArrayBlockingQueue<Order> dockInputBuffer = new ArrayBlockingQueue<Order>(AmazonWebServer.MAX_BUFFER_SIZE);
        ShippingCenterSection section1 = new ShippingCenterSection(section1InputBuffer, dockInputBuffer);
        ShippingCenterSection section2 = new ShippingCenterSection(section2InputBuffer, dockInputBuffer);

        threadExecutor.execute(section1);
        threadExecutor.execute(section2);
        threadExecutor.shutdown();

        Order nextOrder = null;
        try {
            nextOrder = centerInputBuffer.take();
            System.out.println("Order #" + nextOrder.getOrderNumber() + " at shipping center");
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        while (nextOrder.getOrderNumber() != -1){

            if(nextOrder.getCategory().matches("^[A-P].*$")){ //thanks stack overflow!!

                try {
                    nextOrder.setShippingCenterSectionNumber("1");
                    section1InputBuffer.put(nextOrder);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
            else if(nextOrder.getCategory().matches("^[Q-Z].*$")){

                try {
                    nextOrder.setShippingCenterNumber("2");
                    section2InputBuffer.put(nextOrder);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }

            }


            try {
                nextOrder = centerInputBuffer.take();
                System.out.println("Order #" + nextOrder.getOrderNumber() + " at shipping center");
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

        }

    }
}
