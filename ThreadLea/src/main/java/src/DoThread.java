package src;

public class DoThread  extends Thread{
    public DoThread(String name){
        super(name);
    }
    public void run(){

        for(int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException exception){
                exception.printStackTrace();
            }
            System.out.println(this.getName()+""+i);
        }
    }

    public static void main(String[] args) {
        Thread t1=new DoThread("哈哈哈");
        Thread t2=new DoThread("ff");

        Object o=new Object();
        t1.start();
        t2.start();
        t2.setPriority(10);
    }
}
