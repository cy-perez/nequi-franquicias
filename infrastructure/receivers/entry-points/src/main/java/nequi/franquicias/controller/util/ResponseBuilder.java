package nequi.franquicias.controller.util;

import nequi.franquicias.controller.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class ResponseBuilder {

    public static <T> ResponseEntity<ResponseDTO<T>> build200Response(T data) {
        return ResponseEntity.ok(
                ResponseDTO.<T>builder()
                        .transactionId(UUID.randomUUID().toString())
                        .message("Exitoso")
                        .code(200)
                        .data(data)
                        .build());
    }

    public static <T> ResponseEntity<ResponseDTO<T>> build201Response(T data) {
        return ResponseEntity.ok(
                ResponseDTO.<T>builder()
                        .transactionId(UUID.randomUUID().toString())
                        .message("Creacion exitosa")
                        .code(201)
                        .data(data)
                        .build());
    }

    public static <T> ResponseEntity<ResponseDTO<T>> build500Response(String exception) {
        return ResponseEntity.status(500).body(
                ResponseDTO.<T>builder()
                        .transactionId(UUID.randomUUID().toString())
                        .message("Error interno en el servidor: " + exception)
                        .code(500)
                        .build());
    }
}
