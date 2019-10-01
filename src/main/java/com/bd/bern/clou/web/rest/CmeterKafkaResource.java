package com.bd.bern.clou.web.rest;

import com.bd.bern.clou.service.CmeterKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/cmeter-kafka")
public class CmeterKafkaResource {

    private final Logger log = LoggerFactory.getLogger(CmeterKafkaResource.class);

    private CmeterKafkaProducer kafkaProducer;

    public CmeterKafkaResource(CmeterKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
