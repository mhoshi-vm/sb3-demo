package com.engineerhub.dataproducer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class QueueProducer {

    RabbitTemplate rabbitTemplate;

    public QueueProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Bean
    public Queue demoQueue() {
        return new Queue("demoQueue");
    }

    public void handle(String data) {
        this.rabbitTemplate.convertAndSend("demoQueue", data);
    }

}
