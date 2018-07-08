package com.zqw.springboot.learn.boot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
@Slf4j
public class MyStartedListener implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        log.info("服务已经启动啦");
        MyApplicationEvent myEvent = new MyApplicationEvent("myEvent");
        myEvent.setMsg("我自定义了一个事件");
        event.getApplicationContext().publishEvent(myEvent);

    }
}
