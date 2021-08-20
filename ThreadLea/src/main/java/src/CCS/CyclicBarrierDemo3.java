package src.CCS;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 用一个Excel保 存了用户所有银行流水，每个Sheet保存一个账户近一年的每笔银行流水，
 * 现在需要统计用户 的日均银行流水，
 * 先用多线程处理每个sheet里的银行流水，
 * 都执行完之后，得到每个sheet的日 均银行流水，
 * 最后，再用barrierAction用这些线程的计算结果，计算出整个Excel的日均银行流 水
 */
public class CyclicBarrierDemo3 implements Runnable{
    //创建四个屏障
    private CyclicBarrier c = new CyclicBarrier(4,this);
    //启动四个线程
    private Executor executor = Executors.newFixedThreadPool(4);
    //保存每个sheet计算结果
    private ConcurrentHashMap<String,Integer> hashMap=new ConcurrentHashMap<>();
    private void count(){
        for (int i = 0; i <4 ; i++) {
            new Thread(()->{
                //计算当前sheet的数据，计算代码省略
                hashMap.put(Thread.currentThread().getName(),1);
                //计算完成，插入一个屏障
                try {
                    System.out.println(Thread.currentThread().getName()+"被阻塞");
                    c.await();
                    System.out.println("计算完成"+Thread.currentThread().getName()+"被释放");
                }catch (Exception e){
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
    @Override
    public void run() {
      int result=0;
        for (Map.Entry<String,Integer> sheet:hashMap.entrySet()) {
            result+=sheet.getValue();
        }
        //输出结果
        hashMap.put("result",result);
        System.out.println("计算结果"+result);
    }

    public static void main(String[] args) {
        CyclicBarrierDemo3 c=new CyclicBarrierDemo3();
        c.count();
    }
}
