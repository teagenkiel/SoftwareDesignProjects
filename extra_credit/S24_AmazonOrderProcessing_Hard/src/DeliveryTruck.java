import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 *
 *
 */
public class DeliveryTruck implements Runnable{

    private ArrayBlockingQueue<Order> truckInputBuffer;

    public DeliveryTruck(ArrayBlockingQueue truckInputBuffer){

        this.truckInputBuffer = truckInputBuffer;
    }


    @Override
    public void run() {

        boolean terminateThread = true;

        Order nextOrder = null;
        try {
            nextOrder = truckInputBuffer.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        while(terminateThread){

            int deliveryCount = 0;

            System.out.println("Order delivered: " + nextOrder);

            try {
                nextOrder = truckInputBuffer.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

            if (nextOrder.getOrderNumber() == -1){
                terminateThread = false;
            }
        }

    }
}
