package com.zqw.springboot.learn.boot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
@Slf4j
public class MyCustomListener implements ApplicationListener<MyApplicationEvent> {
    @Override
    public void onApplicationEvent(MyApplicationEvent event) {
        String msg = event.getMsg();
        log.info(msg);
    }
}
