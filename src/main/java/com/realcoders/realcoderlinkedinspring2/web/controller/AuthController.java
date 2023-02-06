package com.realcoders.realcoderlinkedinspring2.web.controller;

import com.realcoders.realcoderlinkedinspring2.service.user.UserService;
import com.realcoders.realcoderlinkedinspring2.web.dto.UserDto;
import com.realcoders.realcoderlinkedinspring2.web.response.BasicResponse;
import com.realcoders.realcoderlinkedinspring2.web.validator.user.UserRequestValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserDto userDto){
        UserRequestValidator.validateRequest(userDto);

        userService.register(userDto);
        return new ResponseEntity<>(BasicResponse.of("User created successfully"), HttpStatus.CREATED);
    }
}
