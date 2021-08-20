package src.Notify;

public class ThreadB extends Thread{
    int total;

    public void run() {
        synchronized (this){
            System.out.println("开始计算");
            for(int i=0;i<10;i++){
                total+=i;
            }
            //完成计算之后 唤醒在此对象监视器等待的单个线程。
            notify();
        }
    }
}
