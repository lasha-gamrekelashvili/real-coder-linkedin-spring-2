package com.realcoders.realcoderlinkedinspring2.web.validator.user;

import com.realcoders.realcoderlinkedinspring2.core.exception.AppException;
import com.realcoders.realcoderlinkedinspring2.web.dto.UserDto;
import org.springframework.http.HttpStatus;

public class UserRequestValidator {
    public static void validateRequest(UserDto userDto){
        if( userDto.getPassword() == null || userDto.getPassword().isBlank()){
            throw new AppException("password field can't be null or empty", HttpStatus.BAD_REQUEST);
        }

        if( userDto.getUsername() == null || userDto.getUsername().isBlank() ){
            throw new AppException("username field can't be null or empty", HttpStatus.BAD_REQUEST);
        }

        if( userDto.getEmail() == null || userDto.getEmail().isBlank() ){
            throw new AppException("email field can't be null or empty", HttpStatus.BAD_REQUEST);
        }

        if(userDto.getFull_name() == null || userDto.getFull_name().isBlank()){
            throw new AppException("full_name field can't be null or empty", HttpStatus.BAD_REQUEST);
        }

        if( userDto.getAge() == null ){
            throw new AppException("age field can't be null or empty", HttpStatus.BAD_REQUEST);
        }

    }
}
