package src.CCS;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //参数表示拦截的线程数，只有与参数相同的线程被阻塞之后   CyclicBarrier 才会让这些线程被释放，否则将会被一直阻塞
        CyclicBarrier cyclicBarrier=new CyclicBarrier(4);
        for(int i=0;i<3;i++){
            //拦截子线程
            new Thread(()->{
                try {
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+"已被拦截阻塞");
                }catch (InterruptedException | BrokenBarrierException e){
                    e.printStackTrace();
                }
            }).start();
        }
        //拦截主线程
        try {
            cyclicBarrier.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("主线被阻塞");

    }
}
