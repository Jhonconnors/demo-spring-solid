package com.demo.solid.service.impl.executor;

import com.demo.solid.model.NotificationRequest;
import com.demo.solid.service.ExecutorService;
import com.demo.solid.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcecutorNotification implements ExecutorService {

    private final List<NotificationService> notificationList;

    @Autowired
    public ExcecutorNotification(List<NotificationService> notificationList) {
        this.notificationList = notificationList;

    }

    @Override
    public void execute(NotificationRequest request) {
        for (NotificationService notification : notificationList){
            notification.sendNotification(request.getMessage());
        }
    }
}
