package factory;

import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        Fruit fruit =Factory.getIntance1("Apple");
      // fruit.eat();
        //添加子类时 无需 修改工厂类
        Fruit fruit1 = Factory.getIntance2("factory.impl.Apple");
       // fruit1.eat();
       //通过配置文件获取对象
        Properties pro = init.getPro();
        Fruit fruit2 = Factory.getIntance3(pro.getProperty("orange"));
        if (fruit2!=null)fruit.eat();
    }
}
