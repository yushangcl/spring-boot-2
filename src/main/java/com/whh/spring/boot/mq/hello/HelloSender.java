package com.whh.spring.boot.mq.hello;

import com.whh.spring.boot.model.CmUser;
import com.whh.spring.boot.service.CmUserService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * rabbitmq 生产者
 * @author huahui.wu
 * @date 2018/6/27 09:31
 * @description
 */
@Component
public class HelloSender {

    @Resource
    private AmqpTemplate rabbitTemplate;

    @Resource
    private CmUserService cmUserService;

    public void send() {
        List<CmUser> cmUsers = cmUserService.getUsers();

        String context = "hello " + new Date();
        System.out.println("Sender : " + cmUsers);
        this.rabbitTemplate.convertAndSend("hello", cmUsers);
    }
}
