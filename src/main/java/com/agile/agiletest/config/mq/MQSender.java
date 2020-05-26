package com.agile.agiletest.config.mq;

import com.agile.agiletest.pojo.myMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQSender {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMessage(myMessage message) {
        rabbitTemplate.convertAndSend("DirectExchange", "DirectRouting", message);
    }

}