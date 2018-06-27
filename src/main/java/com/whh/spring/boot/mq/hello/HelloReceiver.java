package com.whh.spring.boot.mq.hello;

import com.whh.spring.boot.model.CmUser;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * rabbitmq 消费者
 * @author huahui.wu
 * @date 2018/6/27 09:32
 * @description
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {
    @RabbitHandler
    public void process(List<CmUser> cmUsers) {
        System.out.println("Receiver : " + cmUsers);
    }
}
