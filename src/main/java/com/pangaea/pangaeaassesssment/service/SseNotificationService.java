package com.pangaea.pangaeaassesssment.service;

import com.pangaea.pangaeaassesssment.model.Notification;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.pangaea.pangaeaassesssment.mapper.EventMapper;
import com.pangaea.pangaeaassesssment.repository.EmitterRepository;

import java.io.IOException;

@Service
@Primary
@AllArgsConstructor
@Slf4j
public class SseNotificationService implements NotificationService {

    private final EmitterRepository emitterRepository;
    private final EventMapper eventMapper;

    @Override
    public void sendNotification(String topic, Notification notification) {
        if (notification == null) {
            log.debug("No server event to send to device.");
            return;
        }
        doSendNotification(topic, notification);
    }

    private void doSendNotification(String topic, Notification notification) {
        emitterRepository.get(topic).ifPresent(sseEmitter -> {
            try {
                log.debug("Sending event: {} for member: {}", notification, topic);
                sseEmitter.send(eventMapper.toSseEventBuilder(notification));
            } catch (IOException | IllegalStateException e) {
                log.debug("Error while sending event: {} for member: {} - exception: {}", notification, topic, e);
                emitterRepository.remove(topic);
            }
        });
    }

}
