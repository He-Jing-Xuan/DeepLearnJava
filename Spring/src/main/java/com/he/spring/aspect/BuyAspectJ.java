package com.he.spring.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BuyAspectJ {
    @After(value = "execution(* com.he.spring.service.IBuy.buy())")
    public void haha(){
        System.out.println("男孩女孩");
    }
}
