package com.realcoders.realcoderlinkedinspring2.web.transformer;

import com.realcoders.realcoderlinkedinspring2.storage.model.UserEntity;
import com.realcoders.realcoderlinkedinspring2.web.dto.UserRegistrationDto;

public class UserTransformer {
    public static UserEntity fromDto(UserRegistrationDto userRegistrationDto){
        UserEntity userEntity = new UserEntity();

        userEntity.setUsername(userRegistrationDto.getUsername());
        userEntity.setEmail(userRegistrationDto.getEmail());
        userEntity.setFull_name(userRegistrationDto.getFull_name());
        userEntity.setPassword(userRegistrationDto.getPassword());
        userEntity.setAge(userRegistrationDto.getAge());

        return userEntity;
    }
}
