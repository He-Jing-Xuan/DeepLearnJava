package src.ThreadPool;

import java.util.Date;
import java.util.concurrent.*;

public class executeDome {
    ///ThreadPoolExecutor
    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 4;
    private static final int QUEUE_CAPACITY = 10;
    private static final Long KEEP_ALIVE_TIME = 1L;
    public static void main(String[] args) {
       ThreadPoolExecutor executor=new ThreadPoolExecutor(CORE_POOL_SIZE,MAX_POOL_SIZE,
               KEEP_ALIVE_TIME, TimeUnit.SECONDS,
               new ArrayBlockingQueue<>(QUEUE_CAPACITY),
               new ThreadPoolExecutor.CallerRunsPolicy());

       for(int i=0;i<20;i++){
           Runnable my=new MyRun(""+i);
           executor.execute(my);
       }
    }
}
class MyRun implements Runnable{
    private String c;
    public MyRun(String v){
        c=v;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
                processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = "
                + new Date());
    }
    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
