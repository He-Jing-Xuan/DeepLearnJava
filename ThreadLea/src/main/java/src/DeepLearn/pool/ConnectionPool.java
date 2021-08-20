package src.DeepLearn.pool;

import java.sql.Connection;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 简单模拟 数据库连接池
 * 用双向队列来维护连接
 * 当连接使用完毕之后 要放回线程池子
 */
public class ConnectionPool {
    //双向队列来维护这个连接池子
    private Deque<Connection> pool=new LinkedList<>();
    //构造函数：初始化连接最大上限
    public ConnectionPool(int initialSize){
        if(initialSize>0){
            for(int i=0;i<initialSize;i++){
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    /**
     * 连接使用完 放回连接池子中
     */
    public void releaseConnection(Connection connection){
        if(connection!=null){
            synchronized (pool){
                //连接释放后 需要进行通知，这样其他消费者才能感知到 有连接可以用了
                pool.addLast(connection);
                //唤醒在等待的消费者
                pool.notify();
            }
        }
    }
    /**
     * 获取连接
     *  在mills内无法获取到连接，将会返回null
     */
    public Connection fetchConnnetion(long mills) throws InterruptedException{
        //获取线程池的锁
        synchronized (pool){
            //完全超时
            if(mills<=0){
                //线程池子 没有连接可以使用 就等待   即条件不足 释放锁
                while (pool.isEmpty()){
                    //释放锁，并等待
                    pool.wait();
                }
                //否则 取出一个连接
                return  pool.removeFirst();
            }else {
                long future=System.currentTimeMillis()+mills;
                long remaining=mills;
                //线程池子 没有连接可用 并且 remaining
                while (pool.isEmpty()&& remaining>0){
                    //pool等待 remaining 秒
                    pool.wait(remaining);
                    //当等待超时之后，就不再等待
                    remaining=future-System.currentTimeMillis();
                }
                Connection result=null;
                //若此时 存在可用连接 就使用，
                if(!pool.isEmpty()){
                     result=pool.removeFirst();
                }
                return  result;
            }
        }
    }
}
