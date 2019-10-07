package com.bd.bern.clou.service;

import com.bd.bern.clou.config.ApplicationProperties;
import com.bd.bern.clou.schema.Carbon;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CmeterKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(CmeterKafkaConsumer.class);
    private ApplicationProperties properties;

    public CmeterKafkaConsumer(ApplicationProperties properties) {
        this.properties = properties;
    }

    @KafkaListener(topics = "${clou.movement-topic}", groupId = "group_id")
    public void consume(ConsumerRecord<String, Carbon> message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) throws IOException {
        log.info("Consumed message in {} : {}", properties.getMovementTopic(), message.value());
    }
}
