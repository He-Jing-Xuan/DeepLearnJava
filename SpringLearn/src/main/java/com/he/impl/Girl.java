package com.he.impl;

import com.he.IBuy;
import org.springframework.stereotype.Component;

@Component
public class Girl implements IBuy {
    @Override
    public String buy() {
        System.out.println("女孩买衣服");
        return "女孩";
    }
}
