package com.engineerhub.dataconsumeandexpose;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Bean
    public Queue demoQueue(){
        return new Queue("demoQueue");
    }

}
