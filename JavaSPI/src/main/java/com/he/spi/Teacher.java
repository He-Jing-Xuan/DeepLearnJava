package com.he.spi;

public class Teacher implements People{
    @Override
    public void walk() {
        System.out.println("老师奔跑");
    }

    @Override
    public void eat(){
        System.out.println("老师吃饭");
    }
}
