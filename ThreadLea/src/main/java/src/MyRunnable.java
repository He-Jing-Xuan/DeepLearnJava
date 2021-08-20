package src;

public class MyRunnable implements Runnable {
    private Foo foo=new Foo();
    public  int fix(int y){
        return  foo.setX(y);
    }
    public synchronized int get(){
        return foo.getX();
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() +"修改"+ this.fix(10));
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " : 当前foo对象的x值= " + this.get());
        }
    }

    public static void main(String[] args) {
        MyRunnable r=new MyRunnable();
        Thread thread1=new Thread(r,"Q");
        Thread thread2=new Thread(r,"B");
        thread1.start();
        thread2.start();
    }
}
