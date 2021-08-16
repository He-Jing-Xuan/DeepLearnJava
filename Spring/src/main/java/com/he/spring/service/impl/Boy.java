package com.he.spring.service.impl;

import com.he.spring.service.IBuy;
import org.springframework.stereotype.Component;

@Component
public class Boy implements IBuy {

    @Override
    public String buy() {
       System.out.println("男孩子买了游戏机");
       return "游戏机";
    }
}
