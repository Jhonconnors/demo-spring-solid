package com.demo.solid.service;

import com.demo.solid.model.NotificationRequest;

public interface ExecutorService {

    void validateOrderValues();
    void execute(NotificationRequest request);

}
