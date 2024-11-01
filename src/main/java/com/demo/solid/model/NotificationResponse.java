package com.demo.solid.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NotificationResponse {

    private String status;

    @JsonProperty("code_operation")
    private String codeOperation;
}
