package com.bd.bern.clou.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CmeterKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(CmeterKafkaConsumer.class);
    private static final String TOPIC = "topic_cmeter";

    @KafkaListener(topics = "topic_cmeter", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}
