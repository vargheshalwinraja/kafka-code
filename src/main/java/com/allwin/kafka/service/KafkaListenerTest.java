package com.allwin.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerTest {

    @KafkaListener(topics = {"topic1", "topic2"}, groupId = "group")
    public void listenTopic1(String message) {
        System.out.println("Received Message in topic: " + message);
    }
}
