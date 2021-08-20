package src.DeepLearn;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {
    static Map<String,Object> map=new HashMap<>();
    static ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    static Lock readLock=readWriteLock.readLock();
    static Lock writeLock=readWriteLock.writeLock();
    public static final Object get(String key){
        readLock.lock();
        try {
            return  map.get(key);
        }finally {
            //释放锁
            readLock.unlock();
        }
    }
    //设置key对应的值，并返回旧的
    public static final Object put(String key,Object value){
        writeLock.lock();
        try{
            return map.put(key,value);
        }finally {
            writeLock.unlock();
        }
    }
    //清空所有内容
    public static final void clear(){
        writeLock.lock();
        try{
            map.clear();
        }finally {
            writeLock.unlock();
        }
    }
}
