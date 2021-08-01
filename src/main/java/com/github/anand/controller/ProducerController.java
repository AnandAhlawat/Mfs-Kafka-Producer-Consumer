package com.github.anand.controller;

import com.github.anand.domain.ProducePayload;
import com.github.anand.domain.ServiceResponse;
import com.github.anand.kafka.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/kafka")
public class ProducerController {

    @Autowired
    Producer producer;

    @PostMapping(value = "/publish")
    public ServiceResponse produce(@RequestBody ProducePayload payload){
        try {
            producer.sendMessage(payload.getKey(), payload.getPayload());
            return ServiceResponse.success("Publish Success");
        }catch (Exception e){
            log.error("Exception occurred while publishing message! : {}",e.getMessage());
            return ServiceResponse.failed("Publish Success");
        }
    }
}
