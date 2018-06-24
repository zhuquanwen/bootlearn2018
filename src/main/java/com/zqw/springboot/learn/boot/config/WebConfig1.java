package com.zqw.springboot.learn.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/*
* 添加Properties转换
* */
@Configuration
public class WebConfig1 implements WebMvcConfigurer {
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new PropertiesHttpMessageConverter());
        converters.add(new BytesHttpMessageConvert());
//        converters.set(0, new BytesHttpMessageConvert());
    }
}
