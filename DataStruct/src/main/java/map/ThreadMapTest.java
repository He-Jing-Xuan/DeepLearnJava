package map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

 class ThreadMapTest implements Runnable {
    public static Map<Integer,Integer> map= new HashMap<Integer,Integer>(2);
    public Map map2 = new LinkedHashMap();
    public  static AtomicInteger atomicInteger= new AtomicInteger();
    @Override
    public void run() {
        while (atomicInteger.get() < 10000) {
            map.put(atomicInteger.get(), atomicInteger.get());
            atomicInteger.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(new ThreadMapTest()).start();
        }
    }

}

