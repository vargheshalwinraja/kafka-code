package com.allwin.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping(path = "/produce/{msg}")
    public ResponseEntity<Object> produce(@PathVariable("msg") String msg) {

        kafkaTemplate.send("topic1", msg + "1");
        kafkaTemplate.send("topic2", msg + "2");

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
