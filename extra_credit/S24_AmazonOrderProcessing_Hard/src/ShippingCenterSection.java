import java.security.SecureRandom;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 *
 *
 *
 */
public class ShippingCenterSection implements Runnable{

    private ArrayBlockingQueue<Order> sectionInputBuffer;
    private ArrayBlockingQueue<Order> sectionOutputBuffer;
    private final SecureRandom generator;
    private final ExecutorService threadExecutor;

    public ShippingCenterSection(ArrayBlockingQueue sectionInputBuffer, ArrayBlockingQueue dockInputBuffer){

        this.sectionInputBuffer = sectionInputBuffer;
        this.sectionOutputBuffer = dockInputBuffer;
        this.generator = new SecureRandom();
        this.threadExecutor = Executors.newCachedThreadPool();
    }


    @Override
    public void run() {

        ShippingDock shippingDock = new ShippingDock(sectionOutputBuffer);
        threadExecutor.execute(shippingDock);
        threadExecutor.shutdown();

        Order nextOrder = null;
        try {
            nextOrder = sectionInputBuffer.take();
            System.out.println("Order # " + nextOrder.getOrderNumber() + "at shipping center section");
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        while(nextOrder.getOrderNumber() != -1){

            int sleepTime = generator.nextInt(5000);

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

            try {
                sectionOutputBuffer.put(nextOrder);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

            try {
                nextOrder = sectionInputBuffer.take();
                System.out.println("Order # " + nextOrder.getOrderNumber() + "at shipping center section");
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
