import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        FileRead fileRead = new FileRead();

        // We can use both the ways to create multiple threads

        /*Thread t1 = new Thread(fileRead);
        t1.start();
        Thread t2 = new Thread(fileRead);
        t2.start();*/

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(int i=0;i<4;i++){
            executorService.execute(fileRead);
        }
    }
}
