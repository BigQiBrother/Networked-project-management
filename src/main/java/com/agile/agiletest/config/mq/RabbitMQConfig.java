package com.agile.agiletest.config.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue buyMessageQueue() {
        return new Queue(MQConstants.BUY, true);
    }


    //Direct交换机 起名：TestDirectExchange
    @Bean
    DirectExchange DirectExchange() {
        return new DirectExchange("DirectExchange");
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(buyMessageQueue()).to(DirectExchange()).with("DirectRouting");
    }
}