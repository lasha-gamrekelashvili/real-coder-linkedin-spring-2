package com.realcoders.realcoderlinkedinspring2.storage.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserEntity {
    @EqualsAndHashCode.Exclude
    private Integer id;
    private String username;
    private String email;
    private String password;
    private String full_name;
    private Integer age;
}
