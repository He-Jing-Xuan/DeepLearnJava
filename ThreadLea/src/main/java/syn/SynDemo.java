package syn;

public class SynDemo {
    public synchronized void dosth(){
        System.out.println("hello ");
        dosth2();
    }
    public synchronized void dosth2(){
        System.out.println("0000 ");
        dosth();
    }

    public void do2(){
        synchronized (SynDemo.class){
            System.out.println("嘻嘻");
        }
    }
}
