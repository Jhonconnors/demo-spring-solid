package com.demo.solid.service.impl.notification;

import com.demo.solid.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(2)
public class EmailNotificationService implements NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(EmailNotificationService.class);


    @Override
    public void sendNotification(String msg) {
        logger.info("Sending e-mail message : {}", msg);
    }


}
