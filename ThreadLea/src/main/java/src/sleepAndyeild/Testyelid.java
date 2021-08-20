package src.sleepAndyeild;

/**
 * 使当前运行着线程让出CPU资源，但是然给谁不知道，仅仅是让出，线程状态回到可运行状态。
 *
 * 线程的让步使用Thread.yield()方法，yield() 为静态方法，功能是暂停当前正在执行的线程对象，并执行其他线程。
 */
public class Testyelid {
    public static void main(String[] args) {
        Thread t1 = new MyThread2();
        Thread t2 = new Thread(new MyRunnable2());
        //t2最先执行一次 之后将cpu资源让给了t1等t1执行完了之后再继续执行t2
        t2.start();
        t1.start();
    }
}
class MyThread2 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程1第" + i + "次执行！");
        }
    }
}

class MyRunnable2 implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程2第" + i + "次执行！");
            // MyRunnable2  让出cup资源
            Thread.yield();
        }
    }
}