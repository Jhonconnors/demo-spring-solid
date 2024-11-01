package com.demo.solid.service.impl.notification;

import com.demo.solid.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(EmailNotificationService.class);

    @Value("${app.order.service.email}")
    private Integer order;
    @Override
    public Integer getOrder() {
        return order;
    }

    @Override
    public void sendNotification(String msg) {
        logger.info("Sending e-mail message : {}", msg);
    }


}
