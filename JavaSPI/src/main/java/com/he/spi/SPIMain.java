package com.he.spi;

import java.util.ServiceLoader;

public class SPIMain {
    public static void main(String[] args) {
        //拿到接口的实现类
        ServiceLoader<People> serviceLoader =ServiceLoader.load(People.class);

        for(People people1:serviceLoader){
            people1.eat();
            people1.walk();
        }
    }
}
