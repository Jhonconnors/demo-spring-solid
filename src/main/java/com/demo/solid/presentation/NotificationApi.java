package com.demo.solid.presentation;


import com.demo.solid.model.NotificationRequest;
import com.demo.solid.model.NotificationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/notification/client")
public interface NotificationApi {

    @Operation(
            summary = "Enviar notificación a un cliente",
            description = "permite enviar notificacion con respecta a una transaccion del cliente y su detalle"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notificación enviada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json"))
    })
    @PostMapping
    ResponseEntity<NotificationResponse> notificationToClient(@RequestBody NotificationRequest request);
}