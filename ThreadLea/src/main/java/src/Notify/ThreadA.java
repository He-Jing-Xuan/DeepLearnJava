package src.Notify;

/**
 * void notify()：唤醒在此对象监视器上等待的单个线程。
 * void notifyAll()：唤醒在此对象监视器上等待的所有线程。
 * void wait()：导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法。
 */
public class ThreadA {
    public static void main(String[] args) {
        ThreadB b=new ThreadB();
        //线程b开始执行
        b.start();
        //线程A拿到了b对象的锁。 线程为了调用wait()或notify()方法，该线程必须是那个对象锁的拥有者
        synchronized (b){
            try {
                System.out.println("等待b线程执行完成");
                b.wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            System.out.println("b对象计算的总和是："+b.total);
        }
    }
}
