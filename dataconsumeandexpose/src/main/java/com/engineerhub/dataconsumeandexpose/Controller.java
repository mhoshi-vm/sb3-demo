package com.engineerhub.dataconsumeandexpose;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    SimpleService simpleService;

    public Controller(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    @GetMapping("/get")
    public Iterable<SimpleEntity> getAll(){
        return simpleService.getAll();
    }

    @RabbitListener(queues = "demoQueue")
    public void consume(String data){
        SimpleEntity simpleEntity = new SimpleEntity();
        simpleEntity.setData(data);
        simpleService.save(simpleEntity);
    }
}
