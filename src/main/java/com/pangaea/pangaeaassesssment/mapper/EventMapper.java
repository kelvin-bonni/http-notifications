package com.pangaea.pangaeaassesssment.mapper;

import com.pangaea.pangaeaassesssment.model.Notification;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Component
@Slf4j
@AllArgsConstructor
public class EventMapper {

    public SseEmitter.SseEventBuilder toSseEventBuilder(Notification notification) {
        return SseEmitter.event()
                .name(notification.getTopic())
                .data(notification.getData());
    }
}
