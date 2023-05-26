package com.engineerhub.dataconsumeandexpose;

import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Component;

@Component
public class SimpleLogic {

    @Observed
    public void logic() throws InterruptedException {
        Thread.sleep(10);
    }
}
