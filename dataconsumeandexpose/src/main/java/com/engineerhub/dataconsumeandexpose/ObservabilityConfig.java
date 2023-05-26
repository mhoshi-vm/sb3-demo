package com.engineerhub.dataconsumeandexpose;

import org.springframework.amqp.rabbit.config.ContainerCustomizer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class ObservabilityConfig {
    @Bean
    ContainerCustomizer<SimpleMessageListenerContainer> containerCustomizer() {
        return (container) -> container.setObservationEnabled(true);
    }
}