package src.Callable;

import java.util.concurrent.Callable;

/**
 * 实现了callable接口  使得该线程拥有了返回值
 */
public class Call implements Callable {
    private String oid;
    public Call(String oid){
        this.oid=oid;
    }
    @Override
    public Object call() throws Exception {
        return oid+"任务返回的内容";
    }
}
