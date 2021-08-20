package src.AQS;

import java.util.concurrent.locks.Lock;

public class TwinsLockTest {
    public static void main(String[] args) throws InterruptedException {
        test();
    }
    public static void test() throws InterruptedException {
        final Lock lock = new TwinsLock();
        class Worker extends Thread {
            public void run()
            {
                while (true) {
                    lock.lock();
                    try {
                        Thread.sleep(200);
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(200);
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    } finally { lock.unlock();
                    }
                }
            }
        }
                    // 启动10个线程
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        // 每隔1秒换行
        for (int i = 0; i < 10; i++)
        {
            Thread.sleep(200);
            System.out.println();
        }
    }
}

