package com.engineerhub.dataproducer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateCustomizer;
import org.springframework.stereotype.Component;

@Component
public class ObservabilityCustomTemplate implements RabbitTemplateCustomizer {

    @Override
    public void customize(RabbitTemplate rabbitTemplate) {
        rabbitTemplate.setObservationEnabled(true);
    }
}