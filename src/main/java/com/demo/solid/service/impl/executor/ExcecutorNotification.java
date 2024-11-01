package com.demo.solid.service.impl.executor;

import com.demo.solid.model.NotificationRequest;
import com.demo.solid.service.ExecutorService;
import com.demo.solid.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExcecutorNotification implements ExecutorService {

    private final List<NotificationService> notificationList;

    @Autowired
    public ExcecutorNotification(List<NotificationService> notificationList) {
        this.notificationList = notificationList;
        validateOrderValues();
        this.notificationList.sort(Comparator.comparingInt(NotificationService::getOrder));
    }

    @Override
    public void validateOrderValues() {
        Set<Integer> orderSet = new HashSet<>();
        for (NotificationService notificationService : notificationList) {
            Integer orderValue = notificationService.getOrder();

            if (orderValue == null || orderValue<0) {
                throw new IllegalArgumentException("El valor de orden debe ser un numero valido para el servicio: "
                        + notificationService.getClass().getName());
            }
            if (!orderSet.add(orderValue)) {
                throw new IllegalArgumentException("El valor de orden " + orderValue +
                        " es duplicado para el servicio: " + notificationService.getClass().getName());
            }
        }
    }


    @Override
    public void execute(NotificationRequest request) {
        for (NotificationService notification : notificationList){
            notification.sendNotification(request.getMessage());
        }
    }
}
