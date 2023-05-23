package com.engineerhub.dataproducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class QueueProducer {

    private static final Logger log = LoggerFactory.getLogger(QueueProducer.class);
    RabbitTemplate rabbitTemplate;

    public QueueProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Bean
    public Queue demoQueue() {
        return new Queue("demoQueue");
    }

    public void handle(String data) {
        log.info("add to demo queue");
        this.rabbitTemplate.convertAndSend("demoQueue", data);
    }

}
