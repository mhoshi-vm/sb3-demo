package com.engineerhub.dataproducer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    QueueProducer queueProducer;

    public Controller(QueueProducer queueProducer) {
        this.queueProducer = queueProducer;
    }

    @PostMapping("/produce")
    public String produce(String data) {
        this.queueProducer.handle(data);
        return "Data Produced";
    }
}
