package src.ProducerAndConsumer;

/**
 * 仓库
 */
public class Godown {
    public static final int max_size=100;//仓库最多库存
    public int curnum;//当前库存量
    public Godown(){}
    public Godown(int curnum){
        this.curnum=curnum;
    }

    /**
     * 生产指定数量的产品的 方法
     * @param neednum
     */
    public synchronized void produce(int neednum){
        //测试是否需要生产
        while (neednum+curnum>max_size){
            System.out.println("要生产的产品数量" + neednum + "超过剩余库存量" + (max_size - curnum) + "，暂时不能执行生产任务!");
            //当前生产现场等待
            try {
                //生产者释放厂库的锁 让消费者获取厂库的锁
                wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        //满足生产条件时， 生产线程进行生产
        curnum+=neednum;
        System.out.println("已经生产了" + neednum + "个产品，现仓储量为" + curnum);
        //唤醒在次对象监视器上等待的所有线程
        notify();
    }

    /**
     * 消费指定数量的方法
     * @param neednum 需要的数量
     */
    public synchronized void consume(int neednum){
        //判断是否可消费，  如果 库存小于neednum则 不能进行消费 通知生产线程 进行生产
        while(curnum<neednum){
            try{
                System.out.println("当前库存不足，等待生产，消费者释放仓库对象锁");
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //满足消费条件时，库存 相应减少
        curnum-=neednum;
        System.out.println("已经消费了" + neednum + "个产品，现仓储量为" + curnum);
        //唤醒在此对象监视器上等待的所有线程
        notify();
    }
}
