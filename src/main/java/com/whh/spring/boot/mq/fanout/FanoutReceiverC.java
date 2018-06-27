package com.whh.spring.boot.mq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * fanout.C
 *
 * @author huahui.wu
 * @date 2018/6/27 10:20
 * @description
 */
@Component
@RabbitListener(queues = "fanout.C")
public class FanoutReceiverC {
    @RabbitHandler
    public void process(String message) {
        System.out.println("fanout Receiver C  : " + message);
    }
}
