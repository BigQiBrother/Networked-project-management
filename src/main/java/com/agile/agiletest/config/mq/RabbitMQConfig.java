package com.agile.agiletest.config.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue buyMessageQueue() {
        return new Queue(MQConstants.BUY, true);
    }

}