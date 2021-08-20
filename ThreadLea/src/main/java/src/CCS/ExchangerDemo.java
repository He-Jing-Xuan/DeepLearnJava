package src.CCS;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *Exchanger是一个线程协作的工具类。用于进行线程间的数据交互。提供一个同步点，在这个同步点，两个线程进行数据交互。
 *如果第一个线程先执行exchange()方法，它会一直等待第二个线程也
 *  执行exchange方法，当两个线程都到达同步点时，这两个线程就可以交换数据，将本线程生产 出来的数据传递给对方
 */
public class ExchangerDemo {
    private static final Exchanger<String> exgr=new Exchanger<>();
    private static ExecutorService threadPool= Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

            threadPool.execute(()->{

                    String A="银行流水A";
                    try {
                        exgr.exchange(A);
                    }catch (Exception e ){
                        e.printStackTrace();
                    }
            });
            threadPool.execute(()->{
                try {
                    String B="银行流水B";//B 录入银行流水的数据。
                    String A=exgr.exchange("B");
                    System.out.println("A和B数据是否一致"+A.equals(B));
                    System.out.println("A录入的数据是："+A+",B录入的数据"+B);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            });
        threadPool.shutdown();
            }
}
