package com.whh.spring.boot.mq.topic;

import com.whh.spring.boot.BaseTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huahui.wu
 * @date 2018/6/27 09:50
 * @description
 */
public class TopicSenderTest extends BaseTests {

    @Autowired
    private TopicSender sender;

    @Test
    public void topic() throws Exception {
        sender.send();
    }

    @Test
    public void topic1() throws Exception {
        sender.send1();
    }

    @Test
    public void topic2() throws Exception {
        sender.send2();
    }

}