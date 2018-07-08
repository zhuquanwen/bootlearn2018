package com.zqw.springboot.learn.boot;

import com.zqw.springboot.learn.boot.interceptor.MyInterceptor;
import com.zqw.springboot.learn.boot.listener.MyCustomListener;
import com.zqw.springboot.learn.boot.listener.MyStartedListener;
import org.apache.catalina.startup.Bootstrap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Random;

@SpringBootApplication
public class BootApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BootApplication.class);
        springApplication.addListeners(new MyStartedListener(), new MyCustomListener());
        springApplication.run( args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor());
    }

    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }
}
