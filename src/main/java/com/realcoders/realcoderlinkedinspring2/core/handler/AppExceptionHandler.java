package com.realcoders.realcoderlinkedinspring2.core.handler;

import com.realcoders.realcoderlinkedinspring2.core.AppException;
import com.realcoders.realcoderlinkedinspring2.web.response.BasicResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = AppException.class)
    private ResponseEntity<Object> handleException(AppException appException){
        return new ResponseEntity<>(BasicResponse.of(appException.getMessage()),appException.getStatus());
    }
}
