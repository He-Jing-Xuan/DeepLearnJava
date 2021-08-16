package com.he.spring.test;

import com.he.spring.config.AppConfig;
import com.he.spring.pojo.User;
import com.he.spring.service.UserService;
import com.he.spring.service.impl.Boy;
import com.he.spring.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext(AppConfig.class);
        Boy buy = c.getBean("boy", Boy.class);
        buy.buy();
    }
}
