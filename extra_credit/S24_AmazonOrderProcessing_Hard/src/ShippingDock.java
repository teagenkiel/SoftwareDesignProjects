import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 *
 *
 */
public class ShippingDock implements Runnable{

    private ArrayBlockingQueue<Order> dockInputBuffer;
    private ArrayBlockingQueue<Order> truck1InputBuffer;
    private ArrayBlockingQueue<Order> truck2InputBuffer;
    private final ExecutorService threadExecutor = Executors.newCachedThreadPool();


    public ShippingDock(ArrayBlockingQueue dockInputBuffer){

        this.dockInputBuffer = dockInputBuffer;
        this.truck1InputBuffer = new ArrayBlockingQueue<Order>(4);
        this.truck2InputBuffer = new ArrayBlockingQueue<Order>(4);
    }


    @Override
    public void run() {

        DeliveryTruck truck1 = new DeliveryTruck(truck1InputBuffer);
        DeliveryTruck truck2 = new DeliveryTruck(truck2InputBuffer);

        threadExecutor.execute(truck1);
        threadExecutor.execute(truck2);
        threadExecutor.shutdown();

        Order nextOrder = null;
        try {
            dockInputBuffer.take();
            System.out.println("Order #" + nextOrder.getOrderNumber() + " at shipping dock");
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        while (nextOrder.getOrderNumber() != -1){

            boolean orderNotAdded = true;

            while(orderNotAdded) {

                if (truck1InputBuffer.size() != 4) {

                    try {
                        nextOrder.setDeliveryTruckNumber("1");
                        truck1InputBuffer.put(nextOrder);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                    orderNotAdded = false;
                } else if (truck2InputBuffer.size() != 4) {

                    try {
                        nextOrder.setDeliveryTruckNumber("2");
                        truck2InputBuffer.put(nextOrder);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                    orderNotAdded = false;
                }
            }

            try {
                nextOrder = dockInputBuffer.take();
                System.out.println("Order #" + nextOrder.getOrderNumber() + " at shipping dock");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
