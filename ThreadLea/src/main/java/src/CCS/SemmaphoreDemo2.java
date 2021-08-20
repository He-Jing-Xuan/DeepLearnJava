package src.CCS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 比如数据库连接。假 如有一个需求，要读取几万个文件的数据，因为都是IO密集型任务，我们可以启动几十个线程 并发地读取，
 * 但是如果读到内存后，还需要存储到数据库中，
 * 而数据库的连接数只有10个，这 时我们必须控制只有10个线程同时获取数据库连接保存数据，
 * 否则会报错无法获取数据库连 接
 */
public class SemmaphoreDemo2 {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore semaphore=new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            threadPool.execute(()->{
                try {
                    //获取
                    semaphore.acquire();
                    System.out.println("保存数据");
                    //释放
                    semaphore.release();
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
        //关闭线程池
        threadPool.shutdown();
    }
}