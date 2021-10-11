package com.pangaea.pangaeaassesssment.service;

import com.pangaea.pangaeaassesssment.model.Notification;
import com.pangaea.pangaeaassesssment.model.SubscribeRequest;
import com.pangaea.pangaeaassesssment.utilities.JsonUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class BusinessLogic {

    private final EmitterService emitterService;
    private final NotificationService notificationService;

    public ResponseEntity<?> subscribe(String topic, SubscribeRequest request){
        log.debug("Subscribing member with id {}", topic);
        SseEmitter sseEmitter = emitterService.createEmitter(topic);
        if (Objects.isNull(sseEmitter))
            return ResponseEntity.badRequest().build();
        else
            return ResponseEntity.ok().build();
    }

    public Object publish(String topic, String request){
        Object object = JsonUtility.fromJson(request, Object.class);
        Notification notification = new Notification(topic, object);
        log.debug("Publishing event {} for member with id {}", notification, topic);
        notificationService.sendNotification(topic, notification);
        return ResponseEntity.ok().build();
    }




}
