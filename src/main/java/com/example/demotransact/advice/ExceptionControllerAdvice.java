package com.example.demotransact.advice;

import com.example.demotransact.dto.error.ErrorDescription;
import com.example.demotransact.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDescription> handleNotFoundException(EntityNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(new ErrorDescription(ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
