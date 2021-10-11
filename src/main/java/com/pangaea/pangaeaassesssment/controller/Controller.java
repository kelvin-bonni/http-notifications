package com.pangaea.pangaeaassesssment.controller;

import com.pangaea.pangaeaassesssment.model.SubscribeRequest;
import com.pangaea.pangaeaassesssment.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pangaea-api")
public class Controller {
    @Autowired
    BusinessLogic businessLogic;

    @PostMapping("/subscribe/{topic}")
    public ResponseEntity<?> subscribe(@PathVariable(name="topic") String topic, @Valid @RequestBody SubscribeRequest request){
        return ResponseEntity.ok(businessLogic.subscribe(topic, request));
    }

    @PostMapping("/publish/{topic}")
    public ResponseEntity<?> publish(@PathVariable(name="topic") String topic, @RequestBody String request){
        return ResponseEntity.ok(businessLogic.publish(topic, request));
    }
}
