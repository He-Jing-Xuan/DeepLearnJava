package factory.impl;

import factory.Fruit;

public class Orange implements Fruit {
    @Override
    public void eat() {
        System.out.println("橘子");
    }

    @Override
    public void walk() {
        System.out.println("橘子");
    }
}
