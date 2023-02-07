package com.realcoders.realcoderlinkedinspring2.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppException extends RuntimeException{
    private HttpStatus status;

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
