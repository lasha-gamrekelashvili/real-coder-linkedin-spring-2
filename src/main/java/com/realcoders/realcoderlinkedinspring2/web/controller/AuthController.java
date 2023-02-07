package com.realcoders.realcoderlinkedinspring2.web.controller;

import com.realcoders.realcoderlinkedinspring2.service.user.UserService;
import com.realcoders.realcoderlinkedinspring2.web.dto.UserDto;
import com.realcoders.realcoderlinkedinspring2.web.dto.UserLoginDto;
import com.realcoders.realcoderlinkedinspring2.web.response.BasicResponse;
import com.realcoders.realcoderlinkedinspring2.web.response.LoginResponse;
import com.realcoders.realcoderlinkedinspring2.web.security.configuration.JwtConfigurationProvider;
import com.realcoders.realcoderlinkedinspring2.web.validator.user.UserLoginValidator;
import com.realcoders.realcoderlinkedinspring2.web.validator.user.UserRequestValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JwtConfigurationProvider jwtConfigurationProvider;


    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserDto userDto){
        UserRequestValidator.validateRequest(userDto);

        userService.register(userDto);
        return new ResponseEntity<>(BasicResponse.of("User created successfully"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserLoginDto userLoginDto){
        UserLoginValidator.validateRequest(userLoginDto);

        String accessKey = jwtConfigurationProvider.generateJWT(userService.login(userLoginDto));
        return new ResponseEntity<>(LoginResponse.of(accessKey), HttpStatus.CREATED);
    }
}
