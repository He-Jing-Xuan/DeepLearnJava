package src.print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReLockPrint implements Runnable {
    private static final int cout = 10;
    private final ReentrantLock lock;
    private final Condition thisCondition;
    private final Condition nextCondtion;
    private final char printChar;
    public ReLockPrint(ReentrantLock lock, Condition thisCondition, Condition nextCondtion,Character printChar) {
        this.lock = lock;
        this.thisCondition = thisCondition;
        this.nextCondtion = nextCondtion;
        this.printChar = printChar;
    }

    @Override
    public void run() {
     lock.lock();
     try{
         for(int i = 0;i < cout;i++){
             System.out.print(printChar);
             nextCondtion.signal();
             if (i < cout - 1) {
                 try {
                     // 本线程让出锁并等待唤醒
                     thisCondition.await();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }
     }finally {
         lock.unlock();
     }
    }

    public static void main(String[] args) throws Exception{
        // 写锁
        ReentrantLock lock = new ReentrantLock();
        // 打印a线程的condition
        Condition conditionA = lock.newCondition();
        // 打印b线程的condition
        Condition conditionB = lock.newCondition();
        // 打印c线程的condition
        Condition conditionC = lock.newCondition();
        // 实例化A线程
        Thread printerA = new Thread(new ReLockPrint(lock, conditionA, conditionB, 'A'));
        // 实例化B线程
        Thread printerB = new Thread(new ReLockPrint(lock, conditionB, conditionC, 'B'));
        // 实例化C线程
        Thread printerC = new Thread(new ReLockPrint(lock, conditionC, conditionA, 'C'));
        // 依次开始A B C线程
        printerA.start();
        Thread.sleep(100);
        printerB.start();
        Thread.sleep(100);
        printerC.start();
    }
}
