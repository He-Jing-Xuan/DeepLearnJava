package src.DeadLock;

public class ThreadDead extends Thread{
    private DeadLockRisk deadLockRisk;
    private int a,b;
    public ThreadDead(DeadLockRisk deadLockRisk,int a,int b){
        this.deadLockRisk=deadLockRisk;
        this.a=a;
        this.b=b;
    }
    @Override
    public void run() {
        deadLockRisk.read();
        deadLockRisk.write(a, b);
    }
}
