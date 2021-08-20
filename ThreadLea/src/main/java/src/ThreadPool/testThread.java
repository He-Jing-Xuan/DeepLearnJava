package src.ThreadPool;

public class testThread {


    public static void main(String[] args) throws Exception{
        Thread thread=new Thread(new mythrea());
        thread.start();
        thread.join();
        System.out.println(thread.isAlive());
        //thread.start();
    }
}
class mythrea implements Runnable{
    @Override
    public void run() {
        System.out.println("ff");
    }
}
