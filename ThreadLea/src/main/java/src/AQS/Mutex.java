package src.AQS;

import java.security.MessageDigest;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 实现自定义同步组件，将会调用同步器提供的模板方法
 */
public class Mutex implements Lock {

  private static class Sync extends AbstractQueuedSynchronizer{
      protected Sync() {
          super();
      }
      //获取状态为0的锁
      @Override
      protected boolean tryAcquire(int arg) {
          //CAS设置同步状态
          if(compareAndSetState(0,1)){
              //将当前线程 设置为 拥有资源的线程。
              setExclusiveOwnerThread(Thread.currentThread());
              return true;
          }
          return false;
      }
      //释放锁，将状态设置为0
      @Override
      protected boolean tryRelease(int arg) {
          if(getState()==0)
              throw new IllegalMonitorStateException();
          setExclusiveOwnerThread(null);
          setState(0);
          return true;
      }

      @Override
      protected int tryAcquireShared(int arg) {
          return super.tryAcquireShared(arg);
      }

      @Override
      protected boolean tryReleaseShared(int arg) {
          return super.tryReleaseShared(arg);
      }
      //是否处于占用状态
      @Override
      protected boolean isHeldExclusively() {
          return getState()==1;
      }
  }
  private final Sync sync=new Sync();
    @Override
    public void lock() {
       sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
      sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
