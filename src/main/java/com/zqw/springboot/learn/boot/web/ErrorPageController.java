package com.zqw.springboot.learn.boot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorPageController {
    @RequestMapping("/403")
    public String to403(){
        return "403";
    }
    @RequestMapping("/404")
    public String to404(){
        return "404";
    }
    @RequestMapping("/400")
    public String to400(){
        return "400";
    }
}
