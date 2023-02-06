package com.realcoders.realcoderlinkedinspring2.web.controller;

import com.realcoders.realcoderlinkedinspring2.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get-all")
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
}
