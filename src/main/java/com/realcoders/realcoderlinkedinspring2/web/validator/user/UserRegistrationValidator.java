package com.realcoders.realcoderlinkedinspring2.web.validator.user;

import com.realcoders.realcoderlinkedinspring2.core.AppException;
import com.realcoders.realcoderlinkedinspring2.web.dto.UserRegistrationDto;
import org.springframework.http.HttpStatus;

public class UserRegistrationValidator {
    public static void validateRequest(UserRegistrationDto userRegistrationDto){
        if( userRegistrationDto.getPassword() == null || userRegistrationDto.getPassword().isBlank()){
            throw new AppException("password field can't be null or empty", HttpStatus.BAD_REQUEST);
        }

        if( userRegistrationDto.getUsername() == null || userRegistrationDto.getUsername().isBlank() ){
            throw new AppException("username field can't be null or empty", HttpStatus.BAD_REQUEST);
        }

        if( userRegistrationDto.getEmail() == null || userRegistrationDto.getEmail().isBlank() ){
            throw new AppException("email field can't be null or empty", HttpStatus.BAD_REQUEST);
        }

        if(userRegistrationDto.getFull_name() == null || userRegistrationDto.getFull_name().isBlank()){
            throw new AppException("full_name field can't be null or empty", HttpStatus.BAD_REQUEST);
        }

        if( userRegistrationDto.getAge() == null ){
            throw new AppException("age field can't be null or empty", HttpStatus.BAD_REQUEST);
        }
    }
}
