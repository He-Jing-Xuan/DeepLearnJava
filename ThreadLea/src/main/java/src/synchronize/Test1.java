package src.synchronize;



public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Object o=new Object();
        User user=new User("贺璟轩",100);
        ThreadSyn th1=new ThreadSyn("线程A",user,20);
        ThreadSyn th2=new ThreadSyn("线程B",user,220);
        ThreadSyn th3=new ThreadSyn("线程C",user,203);
        ThreadSyn th4=new ThreadSyn("线程D",user,212);
        th1.start();
        th2.start();
        th3.start();
        th4.start();

        System.out.println(user.getCash());
    }


}
class ThreadSyn extends Thread{
    private User user;
    private int y=0;
    ThreadSyn(String name,User user,int y){
        super(name);
        this.user=user;
        this.y=y;
    }
    public void run(){
        user.oper(y);
        user.write();
    }
}
class User{
    private String code;
    private int cash;

    public User(String code, int cash) {
        this.code = code;
        this.cash = cash;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public int getCash(){
        return cash;
    }

    /**
     * 业务方法
     */
    public synchronized void oper(int x){
        try {
            Thread.sleep(10L);
            this.cash+=x;
            System.out.println(Thread.currentThread().getName()+"运行结束，增加“" + x + "”，当前用户账户余额为：" + cash);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
    public void write(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+"hello synchroized");
        }
    }
}
