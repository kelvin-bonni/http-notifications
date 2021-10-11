package com.pangaea.pangaeaassesssment.service;

import com.pangaea.pangaeaassesssment.model.Notification;

public interface NotificationService {

    void sendNotification(String topic, Notification notification);
}
