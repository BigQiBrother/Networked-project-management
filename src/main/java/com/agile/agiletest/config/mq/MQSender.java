package com.agile.agiletest.config.mq;

import com.agile.agiletest.pojo.Message;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Message message) {
        amqpTemplate.convertAndSend(MQConstants.BUY, message);
    }

}