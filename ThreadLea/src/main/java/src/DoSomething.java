package src;

public class DoSomething implements Runnable {
    private  String name;
    public DoSomething(String name){
        this.name=name;
    }
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("hello Runnable" + name);
            }
        }
    }
}
