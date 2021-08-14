package proxy.iml;

import proxy.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public void say() {
        System.out.println("hello");
    }
    public  void walk(){
        System.out.println("快跑呀");
    }
}
