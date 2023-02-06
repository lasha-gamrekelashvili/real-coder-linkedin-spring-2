package com.realcoders.realcoderlinkedinspring2.web.transformer;

import com.realcoders.realcoderlinkedinspring2.storage.model.UserEntity;
import com.realcoders.realcoderlinkedinspring2.web.dto.UserDto;

public class UserTransformer {
    public static UserEntity fromDto(UserDto userDto){
        UserEntity userEntity = new UserEntity();

        userEntity.setUsername(userDto.getUsername());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setFull_name(userDto.getFull_name());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setAge(userDto.getAge());

        return userEntity;
    }
}
