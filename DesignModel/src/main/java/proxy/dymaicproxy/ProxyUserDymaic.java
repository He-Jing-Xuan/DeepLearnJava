package proxy.dymaicproxy;

import proxy.MyTransaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUserDymaic implements InvocationHandler {
    private Object target;
    private MyTransaction transaction;
    public ProxyUserDymaic(Object target, MyTransaction transaction){
        this.target = target;
        this.transaction = transaction;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        transaction.before();
        Object result = method.invoke(target,args);
        transaction.after();
        return  result;
    }
    public Object getBean(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), this.target.getClass().getInterfaces(),this);
    }
}
