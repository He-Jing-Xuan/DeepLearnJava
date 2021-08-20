package src.ProducerAndConsumer;

public class Test {
    public static void main(String[] args) {
        //只有一个仓库对象
        Godown godown = new Godown(30);
        //三个消费者
        Consumer c1 = new Consumer(50, godown);
        //四个生产者
        Producer p1 = new Producer(10, godown);
        c1.start();
        p1.start();

    }
}
