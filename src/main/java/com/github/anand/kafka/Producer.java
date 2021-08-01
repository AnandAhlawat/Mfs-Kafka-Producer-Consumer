package com.github.anand.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Producer {

    @Value("${mfs.topic.name}")
    String topicName;

    @Value("${mfs.topic.partition}")
    Integer partition;

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String key, String message){
        log.info("Producing message : {}",message);
        this.kafkaTemplate.send(topicName,partition,key,message);
    }
}
