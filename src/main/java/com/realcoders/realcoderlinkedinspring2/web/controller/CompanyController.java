package com.realcoders.realcoderlinkedinspring2.web.controller;

import com.realcoders.realcoderlinkedinspring2.web.dto.CompanyCreationDto;
import com.realcoders.realcoderlinkedinspring2.web.response.BasicResponse;
import com.realcoders.realcoderlinkedinspring2.web.validator.company.CompanyCreationValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @PostMapping("")
    public ResponseEntity<Object> dummy(@RequestBody CompanyCreationDto companyCreationDto){
        CompanyCreationValidator.validateRequest(companyCreationDto);
        return new ResponseEntity<>(BasicResponse.of("Company created successfully"), HttpStatus.CREATED);
    }
}
