package src.DeepLearn.pool;

import sun.awt.windows.ThemeReader;

import java.sql.Connection;
import java.util.GregorianCalendar;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.CRC32;

public class ConnectionPoolTest {
    //初始化10个连接
    static ConnectionPool pool=new ConnectionPool(10);
    // 保证所有ConnectionRunner能够同时开始
    static CountDownLatch start = new CountDownLatch(1);
    // main线程将会等待所有ConnectionRunner结束后才能继续执行
    static CountDownLatch end;

    public static void main(String[] args) throws Exception {
        // 线程数量，可以修改线程数量进行观察
        int threadCount=20;
        end=new CountDownLatch(threadCount);
        int count=20;
        AtomicInteger got=new AtomicInteger();
        AtomicInteger notGot=new AtomicInteger();
        for(int i=0;i<threadCount;i++){
            //启动threadCount个   ConnetionRunner  去争夺线程池资源
            Thread thread=new Thread(new ConnetionRunner(count,got,notGot),"ConnectionRunnerThread");
                   thread.start();
        }
        start.countDown();
        //主线程在 ConnetionRunner执行完之后才会继续执行
        end.await();
        System.out.println("total invoke: " + (threadCount * count));
        System.out.println("got connection: " + got);
        System.out.println("not got connection " + notGot);

    }
    static class ConnetionRunner implements Runnable{
        int count;
        AtomicInteger got;
        AtomicInteger notGot;
        public ConnetionRunner(int count, AtomicInteger got, AtomicInteger notGot){
            this.count=count;
            this.got=got;
            this.notGot=notGot;
        }
        @Override
        public void run() {
            try {
                start.await();
            } catch (Exception ex) {

            }
           while (count>0){
               // 从线程池中获取连接，如果1000ms内无法获取到，将会返回null
               // 分别统计连接获取的数量got和未获取到的数量notGot
               try {
                   Connection connection=pool.fetchConnnetion(1000);
                   //connection不为空则表示得到了连接
                   if (connection != null) {
                       try {
                           connection.createStatement();
                           connection.commit();
                       }
                       finally {
                           pool.releaseConnection(connection);
                           //获取到了连接 原子加
                           got.incrementAndGet();
                       }
                   }//未得到连接
                   else {
                       notGot.incrementAndGet();
                   }
               } catch (Exception exception) {
                   exception.printStackTrace();
               }finally {
                   count--;
               }
           }
           end.countDown();
        }
    }
}
