package proxy;

import javafx.beans.binding.ObjectExpression;
import proxy.dymaicproxy.MyInvocationHandler;
import proxy.iml.HelloServiceImpl;
import proxy.staticproxy.HelloServiceProxy;

public class Main {
    public static void main(String[] args) {
        MyInvocationHandler handler =new MyInvocationHandler(new HelloServiceImpl());
        HelloService service = (HelloService) handler.getProxy();
        service.say();
        service.walk();
      //  Class  c = service.getClass();
    }
}
