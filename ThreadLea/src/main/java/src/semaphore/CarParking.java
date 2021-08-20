package src.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CarParking {
    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for(int i = 0;i< 100;i++){

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("欢迎 " + Thread.currentThread().getName() + " 来到停车场");
                    // 判断是否允许停车
                    if(semaphore.availablePermits() == 0) {
                        System.out.println("车位不足，请耐心等待");
                    }
                    try {
                        // 尝试获取
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + " 进入停车场");
                        Thread.sleep(new Random().nextInt(10000));// 模拟车辆在停车场停留的时间
                        System.out.println(Thread.currentThread().getName() + " 驶出停车场");
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, i + "号车");

            thread.start();
        }


    }
}
