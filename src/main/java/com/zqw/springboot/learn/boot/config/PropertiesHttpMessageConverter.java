package com.zqw.springboot.learn.boot.config;

import com.zqw.springboot.learn.boot.domain.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Properties;

public class PropertiesHttpMessageConverter extends
        AbstractHttpMessageConverter<User> {
    public PropertiesHttpMessageConverter() {
        super(MediaType.valueOf(Constants.PROPERTIES_USER));
        setDefaultCharset(Charset.forName("utf-8"));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(User.class);
    }

    @Override
    protected User readInternal(Class<? extends User> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream is = inputMessage.getBody();
        Properties props = new Properties();
        props.load(is);
        String id = props.getProperty("id");
        String name = props.getProperty("name");
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    @Override
    protected void writeInternal(User user, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream os = outputMessage.getBody();
        Properties properties = new Properties();
        properties.setProperty("id", user.getId());
        properties.setProperty("name", user.getName());
        properties.store(os, "user comments");
    }
}
