package com.zqw.springboot.learn.boot.web;

import com.zqw.springboot.learn.boot.config.Constants;
import com.zqw.springboot.learn.boot.domain.User;
import com.zqw.springboot.learn.boot.utils.MathUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class UserController {
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id){
        User user = new User();
        user.setId(id);
        return user;
    }
    /*将json转为properties*/
    @PostMapping(value = "/user/json2prop",
                consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},
                produces = {Constants.PROPERTIES_USER})
    public User json2prop(@RequestBody User user){
        return user;
    }
    /*将properties转为json*/
    @PostMapping(value ="/user/prop2json",
                consumes = {Constants.PROPERTIES_USER},
                produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public User prop2json(@RequestBody User user){
        return user;
    }




}
