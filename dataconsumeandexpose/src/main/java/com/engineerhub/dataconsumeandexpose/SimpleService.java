package com.engineerhub.dataconsumeandexpose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SimpleService {

    private static final Logger log = LoggerFactory.getLogger(SimpleService.class);
    SimpleRepository simpleRepository;

    SimpleLogic simpleLogic;

    public SimpleService(SimpleRepository simpleRepository, SimpleLogic simpleLogic) {
        this.simpleRepository = simpleRepository;
        this.simpleLogic = simpleLogic;
    }

    public Iterable<SimpleEntity> getAll(){
        return simpleRepository.findAll();
    }

    public void save(SimpleEntity entity){
        simpleRepository.save(entity);
    }

    @RabbitListener(queues = "demoQueue")
    public void consume(String data) throws InterruptedException {
        log.info("new data from queue");
        SimpleEntity simpleEntity = new SimpleEntity();
        simpleEntity.setData(data);
        simpleLogic.logic();
        save(simpleEntity);
    }
}
