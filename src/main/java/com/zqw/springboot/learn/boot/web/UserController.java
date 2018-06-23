package com.zqw.springboot.learn.boot.web;

import com.zqw.springboot.learn.boot.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id){
        User user = new User();
        user.setId(id);
        return user;
    }
}
