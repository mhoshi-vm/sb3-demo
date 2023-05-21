package com.engineerhub.dataconsumeandexpose;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {

    SimpleRepository simpleRepository;

    public SimpleService(SimpleRepository simpleRepository) {
        this.simpleRepository = simpleRepository;
    }

    public Iterable<SimpleEntity> getAll(){
        return simpleRepository.findAll();
    }

    public void save(SimpleEntity entity){
        simpleRepository.save(entity);
    }
}
