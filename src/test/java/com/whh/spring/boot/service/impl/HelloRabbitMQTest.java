package com.whh.spring.boot.service.impl;

import com.whh.spring.boot.BaseTests;
import com.whh.spring.boot.mq.hello.HelloSender;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huahui.wu
 * @date 2018/6/27 09:33
 * @description
 */
public class HelloRabbitMQTest extends BaseTests {
    @Autowired
    private HelloSender sender;

    @Test
    public void rabbitTest() {
        sender.send();
    }
}
