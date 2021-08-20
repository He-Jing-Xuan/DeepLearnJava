package src.DeadLock;

public class Test {
    public static void main(String[] args) {
        DeadLockRisk deadLockRisk=new DeadLockRisk();
        ThreadDead t1=new ThreadDead(deadLockRisk,1,2);
        ThreadDead t2=new ThreadDead(deadLockRisk,1,2);
        ThreadDead t3=new ThreadDead(deadLockRisk,1,2);
    }
}
