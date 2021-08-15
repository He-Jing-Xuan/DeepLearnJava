package proxy.dymaicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserInvocationHandler implements InvocationHandler {
    private Object target;
    public UserInvocationHandler(Object target){
        super();
        this.target=target;
    }
    //代理增强逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       System.out.println("方法增强啦");
       String methonName = method.getName();
       if(methonName.equals("add")){
           System.out.println("执行添加用户的执行逻辑");
       }
       if(methonName.equals("login")){
           System.out.println("执行用户登录逻辑");
       }
       Object result =method.invoke(target,args);
       return  result;
    }
    public  Object getBean(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),target.getClass().getInterfaces(),this);
    }
}
