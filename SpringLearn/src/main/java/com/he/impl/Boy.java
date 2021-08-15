package com.he.impl;

import com.he.IBuy;
import org.springframework.stereotype.Component;

@Component
public class Boy implements IBuy {
    @Override
    public String buy() {
        System.out.println("男孩买东西");
        return "游戏机";
    }
}
