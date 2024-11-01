package com.demo.solid.presentation;

import com.demo.solid.model.NotificationRequest;
import com.demo.solid.model.NotificationResponse;
import com.demo.solid.service.ExecutorService;
import com.demo.solid.service.impl.executor.ExcecutorNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController implements NotificationApi {

    private final ExecutorService excecutorNotification;
    @Autowired
    public NotificationController(ExcecutorNotification excecutorNotification) {
        this.excecutorNotification = excecutorNotification;
    }

    @Override
    public ResponseEntity<NotificationResponse> notificationToClient(NotificationRequest request) {
        excecutorNotification.execute(request);
        NotificationResponse response = new NotificationResponse();
        response.setStatus("SUCCESS");
        response.setCodeOperation("200_OK");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}