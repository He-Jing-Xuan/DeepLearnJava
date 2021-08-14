package proxy.staticproxy;

import proxy.HelloService;
import proxy.iml.HelloServiceImpl;

/**
 * 静态代理 代理了接口， 并对方法实现了扩展
 */
public class HelloServiceProxy implements HelloService {
   private HelloService target;
   public HelloServiceProxy(HelloService helloService){
       this.target = helloService;
   }
    @Override
    public void say() {
        System.out.println("记录日志");
        target.say();
    }

    @Override
    public void walk() {

    }
}
