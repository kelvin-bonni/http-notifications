package com.pangaea.pangaeaassesssment.service;

import com.pangaea.pangaeaassesssment.model.SubscribeRequest;
import com.pangaea.pangaeaassesssment.utilities.JsonUtility;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BusinessLogic {
    public ResponseEntity<?> subscribe(String topic, SubscribeRequest request){
        return null;
    }

    public Object publish(String request){

        Object object = JsonUtility.fromJson(request, Object.class);
        return object;
    }
}
