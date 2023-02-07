package com.realcoders.realcoderlinkedinspring2.web.validator.user;

import com.realcoders.realcoderlinkedinspring2.core.AppException;
import com.realcoders.realcoderlinkedinspring2.web.dto.UserLoginDto;
import org.springframework.http.HttpStatus;

public class UserLoginValidator {

    public static void validateRequest(UserLoginDto userLoginDto){
        if( userLoginDto.getPassword() == null || userLoginDto.getPassword().isBlank()){
            throw new AppException("password field can't be null or empty", HttpStatus.BAD_REQUEST);
        }

        if( userLoginDto.getUsername() == null || userLoginDto.getUsername().isBlank() ){
            throw new AppException("username field can't be null or empty", HttpStatus.BAD_REQUEST);
        }
    }
}
