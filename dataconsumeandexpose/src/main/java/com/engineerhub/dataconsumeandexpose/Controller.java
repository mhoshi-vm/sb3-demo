package com.engineerhub.dataconsumeandexpose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static final Logger log = LoggerFactory.getLogger(Controller.class);

    SimpleService simpleService;

    public Controller(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    @GetMapping("/get")
    public Iterable<SimpleEntity> getAll(){
        log.info("get all data");
        return simpleService.getAll();
    }

}
