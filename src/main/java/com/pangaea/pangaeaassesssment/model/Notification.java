package com.pangaea.pangaeaassesssment.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notification {
    String topic;
    Object data;
}
