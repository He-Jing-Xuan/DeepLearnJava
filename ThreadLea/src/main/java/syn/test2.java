package syn;

public class test2 {
    Object lock = new Object();
    public void print(){
       synchronized (lock){
           System.out.println(Thread.currentThread().getName()+ "嘻嘻");
           try {
               Thread.sleep(1000);
           }catch (Exception e){
               e.printStackTrace();
           }
       }
    }
static class Thred1 extends Thread{
        test2 t;

    public Thred1(test2 t3) {
        t = t3;
    }


    @Override
    public void run() {
        t.print();

    }
}
    public static void main(String[] args) {
        test2 t3 = new test2();
        Thred1 t1 =new Thred1(t3);
        Thred1 t2 =new Thred1(t3);
        t1.start();
       t2.start();
    }
}
