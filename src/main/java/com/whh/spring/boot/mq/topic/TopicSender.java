package com.whh.spring.boot.mq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送send1会匹配到topic.#和topic.message 两个Receiver都可以收到消息，
 * 发送send2只有topic.#可以匹配所有只有Receiver2监听到消息
 *
 * @author huahui.wu
 * @date 2018/6/27 09:47
 * @description
 */
@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hi, i am message all";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.1", context);
    }

    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
    }

    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", context);
    }

}
