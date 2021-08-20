package src.Notify;

public class ReaderResult  extends Thread{
    Calculator calculator;
    public ReaderResult(Calculator calculator){
        this.calculator=calculator;
    }
    public void run(){
        // ReaderResult获取Calculator对象的锁
        synchronized (calculator){
            try {
                System.out.println(Thread.currentThread() + "等待计算结果。。。");
                calculator.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "计算结果为：" + calculator.total);
        }
    }
}
