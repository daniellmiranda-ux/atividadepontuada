package com.example.atividade.expection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExpection {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> erro(RuntimeException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("mensagem", e.getMessage()));
    }

}
