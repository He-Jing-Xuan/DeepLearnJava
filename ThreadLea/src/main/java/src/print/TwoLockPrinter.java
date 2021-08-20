package src.print;

public class TwoLockPrinter implements Runnable{
    private static final int print_count = 10;
    private final Object fontLock;
    private  final Object thisLock;
    private final char printChar;

    public TwoLockPrinter(Object fontLock, Object thisLock, char printChar) {
        this.fontLock = fontLock;
        this.thisLock = thisLock;
        this.printChar = printChar;
    }

    @Override
    public void run() {
        for(int i=0 ;i<print_count ;i++){
            synchronized (fontLock){
                synchronized (thisLock){
                    System.out.println(printChar);
                    thisLock.notify();
                }
            }
            if(i< print_count-1){
                try {
                    fontLock.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        // 打印A线程的锁
        Object lockA = new Object();
        // 打印B线程的锁
        Object lockB = new Object();
        // 打印C线程的锁
        Object lockC = new Object();
        // 打印a的线程
        Thread threadA = new Thread(new TwoLockPrinter(lockC, lockA, 'A'));
        // 打印b的线程
        Thread threadB = new Thread(new TwoLockPrinter(lockA, lockB, 'B'));
        // 打印c的线程
        Thread threadC = new Thread(new TwoLockPrinter(lockB, lockC, 'C'));

        // 依次开启a b c线程
        threadA.start();
        Thread.sleep(100); // 确保按顺序A、B、C执行
        threadB.start();
        Thread.sleep(100);
        threadC.start();
        Thread.sleep(100);
    }
}
