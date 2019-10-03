package com.bd.bern.clou.service;

import com.bd.bern.clou.config.ApplicationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CmeterKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(CmeterKafkaConsumer.class);
    private ApplicationProperties properties;

    public CmeterKafkaConsumer(ApplicationProperties properties) {
        this.properties = properties;
    }

    @KafkaListener(topics = "${application.movement-topic}", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", properties.getMovementTopic(), message);
    }
}
