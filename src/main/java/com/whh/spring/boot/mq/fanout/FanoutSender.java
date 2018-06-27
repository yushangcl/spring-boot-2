package com.whh.spring.boot.mq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 这里使用了A、B、C三个队列绑定到Fanout交换机上面，发送端的routing_key写任何字符都会被忽略：
 *
 * @author huahui.wu
 * @date 2018/6/27 10:19
 * @description
 */
@Component
public class FanoutSender {
    @Resource
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hi, fanout msg ";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange", "", context);
    }

}
