package com.github.anand.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Consumer {

    @KafkaListener(topics = "${mfs.topic.name}", groupId = "${mfs.topic.groupId}")
    public void consume(String message){
        log.info("message received : {}",message);
    }
}
