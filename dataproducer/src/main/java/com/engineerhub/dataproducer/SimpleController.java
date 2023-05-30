package com.engineerhub.dataproducer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    QueueProducer queueProducer;

    public SimpleController(QueueProducer queueProducer) {
        this.queueProducer = queueProducer;
    }

    @PostMapping("/produce")
    public String produce(@RequestBody String data) {
        this.queueProducer.handle(data);
        return "Data Produced";
    }
}
