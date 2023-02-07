package com.realcoders.realcoderlinkedinspring2.web.dto;

import lombok.Data;
@Data
public class UserRegistrationDto {
    private String username;
    private String email;
    private String password;
    private String full_name;
    private Integer age;
}
