package src.CCS;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count=new CountDownLatch(5);
        for(int i=0;i<5;i++){
            new Thread(()->{
               System.out.println(Thread.currentThread().getName()+"倒数");
               count.countDown();
            }).start();

        }
        //等上面的代码执行完了 主线程才会继续执行，  类似于join();
        count.await();
        System.out.println("oo");
    }
}
