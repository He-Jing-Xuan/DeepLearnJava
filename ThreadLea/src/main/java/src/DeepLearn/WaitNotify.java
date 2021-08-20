package src.DeepLearn;

/**
 * 使用wait（），notify（），notify All（)需要先对 调用对象 加锁
 * 调用 wait()方法后，线程状态 由Running 到waiting ，并将当前线程放置到对象的 等待队列
 * notify()或notifyAll()方法调用后，等待线程依旧不会从wait()返回，
 * 需要调用notify()或 notifAll()的线程释放锁之后，等待线程才有机会从wait()返回。
 * ）notify()方法将等待队列中的一个等待线程从等待队列中移到同步队列中，而notifyAll() 方法则是将等待队列中所有的线程全部移到同步队列，
 * 被移动的线程状态由WAITING变为 BLOCKED
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotify {
    static boolean flag=true;
    static Object lock=new Object();

    public static void main(String[] args) throws InterruptedException {
         Thread waitThread= new Thread(new Wait(), "WaitThread");
         //启动线程
        waitThread.start();
        //停顿一下
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread=new Thread(new Notify(),"NotifyThread");
        notifyThread.start();

    }
    static class Wait implements Runnable{
        @Override
        public void run() {
            //对拥有lock的Monitor加锁
            synchronized (lock){
                while (flag){
                    System.out.println(Thread.currentThread()+"flag is true,"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    try {
                        //lock进行等待,释放锁
                        lock.wait();
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread() + " flag is false. running @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }
    static class Notify implements Runnable {
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized (lock) {
                // 获取lock的锁，然后进行通知，通知时不会释放lock的锁，
                // 直到当前线程释放了lock后，WaitThread才能从wait方法中返回
                System.out.println(Thread.currentThread() + " hold lock. notify @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                //  唤醒 等待队列的线程 但此时不会释放锁
                lock.notifyAll();
                flag = false;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
            // 再次加锁
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again. sleep @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}

