package OnlineAssignment.bayonesolution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadQuestion {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(int i = 0; i < 7; i++){
            Thread thread = new Thread(()->{
                System.out.println("T:1:" + Thread.currentThread().getName() );
            });
            thread.start();
        }
        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(()->{
                System.out.println("T:2:" + Thread.currentThread().getName());
            });
            executorService.execute(thread);
        }
    }


}
