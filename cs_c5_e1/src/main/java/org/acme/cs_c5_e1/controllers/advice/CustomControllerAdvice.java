package org.acme.cs_c5_e1.controllers.advice;

import lombok.extern.slf4j.Slf4j;
import org.acme.cs_c5_e1.services.exceptions.AlreadyExistingProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class CustomControllerAdvice {

    @ExceptionHandler(AlreadyExistingProductException.class)
    public ResponseEntity<?> conflict() {
        log.error("...");
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
