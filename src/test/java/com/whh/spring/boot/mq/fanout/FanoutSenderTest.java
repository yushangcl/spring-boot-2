package com.whh.spring.boot.mq.fanout;

import com.whh.spring.boot.BaseTests;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author huahui.wu
 * @date 2018/6/27 10:22
 * @description
 */
public class FanoutSenderTest extends BaseTests {

    @Resource
    private FanoutSender fanoutSender;

    @Test
    public void send() {
        fanoutSender.send();
    }
}