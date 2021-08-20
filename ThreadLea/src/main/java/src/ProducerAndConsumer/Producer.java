package src.ProducerAndConsumer;

/**
 * 生产者
 */
public class Producer extends Thread{
    private int neednum;   //生产产品的数量
    private Godown godown;  //仓库
    public Producer(int neednum,Godown godown){
        this.godown=godown;
        this.neednum=neednum;
    }

    public void run(){
        //生产指定数量的产品
        godown.produce(neednum);
    }
}
