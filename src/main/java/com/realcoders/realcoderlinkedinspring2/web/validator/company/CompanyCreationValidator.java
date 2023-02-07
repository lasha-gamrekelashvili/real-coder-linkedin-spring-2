package com.realcoders.realcoderlinkedinspring2.web.validator.company;

import com.realcoders.realcoderlinkedinspring2.core.AppException;
import com.realcoders.realcoderlinkedinspring2.web.dto.CompanyCreationDto;
import org.springframework.http.HttpStatus;

public class CompanyCreationValidator {
    public static void validateRequest(CompanyCreationDto companyCreationDto){
        if( companyCreationDto.getName() == null || companyCreationDto.getName().isBlank()){
            throw new AppException("name field can't be null or empty", HttpStatus.BAD_REQUEST);
        }
    }
}
