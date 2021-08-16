package com.he.spring.service;

import com.he.spring.pojo.User;
import org.springframework.stereotype.Component;


public interface UserService {
    void add(User user);
    void delete(User user);
    void login(User user);

}
