package com.he.config;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
public class BuyAspectj {
    public void haha(){
        System.out.println("男孩女孩都买自己喜欢的东西");
    }
}
