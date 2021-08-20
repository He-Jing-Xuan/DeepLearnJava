package src.CCS;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量 用于控制 访问特定资源的线程数量，来协调线程，来保证合理使用公共资源。
 * 应用场景： 流量控制。
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(5);//5个车位
        for(int i=0;i<10;i++){
          new Thread(()->{
              try {
                  semaphore.acquire();
                  System.out.println(Thread.currentThread().getName()+"/t 抢到车位");
                  try {
                      TimeUnit.SECONDS.sleep(3);
                      System.out.println(Thread.currentThread().getName()+"/t释放车位");
                  }catch (InterruptedException e){
                      e.printStackTrace();
                  }
              }catch (InterruptedException e){
                  e.printStackTrace();
              }finally {
                  semaphore.release();
              }

          },String.valueOf(i)).start();
        }
    }

}
