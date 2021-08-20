package src.CCS;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier的字面意思是可循环使用（Cyclic）的屏障（Barrier）。它要做的事情是，
 * 让一 组线程到达一个屏障（也可以叫同步点）时被阻塞，
 * 直到最后一个线程到达屏障时，屏障才会 开门，所有被屏障拦截的线程才会继续运行
 */
public class CyclicBarrierDemo2 {
   static CyclicBarrier cyclicBarrier=new CyclicBarrier(4,new A());

    public static void main(String[] args) {
        for(int i=0;i<4;i++){
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"被阻塞，等待被释放");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+"释放");
                }catch (Exception e){
                    e.printStackTrace();
                }

            },String.valueOf(i)).start();
        }
    }
}
class A implements Runnable{
    @Override
    public void run() {
        System.out.println("我是更复杂的业务，当其他线程都被阻塞之后我才会执行");
    }
}
