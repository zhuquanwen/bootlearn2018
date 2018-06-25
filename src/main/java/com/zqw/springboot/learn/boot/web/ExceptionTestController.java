package com.zqw.springboot.learn.boot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionTestController {
    @GetMapping("/exception")
    public String toException(){
        throw new RuntimeException("出错了");
//        return "success";
    }
}
