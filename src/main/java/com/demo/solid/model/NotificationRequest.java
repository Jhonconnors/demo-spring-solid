package com.demo.solid.model;


import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NotificationRequest {
    private String id;
    private String name;
    private String message;
}
