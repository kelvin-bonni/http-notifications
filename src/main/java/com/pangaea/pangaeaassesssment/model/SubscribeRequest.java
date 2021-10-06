package com.pangaea.pangaeaassesssment.model;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class SubscribeRequest {
    @URL
    String url;
}
