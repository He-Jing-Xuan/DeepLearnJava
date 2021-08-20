package src.Notify;

public class TestNotifyAll {
    public static void main(String[] args) {
        Calculator calculator=new Calculator();

        //开启三个线程来得到同一个对象的锁，等待被唤醒
        new ReaderResult(calculator).start();
        new ReaderResult(calculator).start();
        new ReaderResult(calculator).start();
        calculator.start();
    }


}
