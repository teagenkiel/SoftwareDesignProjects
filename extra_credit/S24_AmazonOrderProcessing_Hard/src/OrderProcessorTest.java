import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 *
 */
public class OrderProcessorTest {

    public static void main(String[] args){

        final int MAX_BUFFER_SIZE = 21;
        ExecutorService myExecutor = Executors.newCachedThreadPool();
        ArrayBlockingQueue<Order> webServerOutput = new ArrayBlockingQueue<Order>(MAX_BUFFER_SIZE);

        AmazonWebServer webServer1 = null;

        try {
            webServer1 = new AmazonWebServer(webServerOutput, "S24_AmazonOrderProcessing_OrdersFile.csv");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error reading file" + e);
        }


        myExecutor.execute(webServer1);



        myExecutor.shutdown();

        try {
            myExecutor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(webServerOutput);


    }
}
