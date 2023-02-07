package com.realcoders.realcoderlinkedinspring2.service.user;

import com.realcoders.realcoderlinkedinspring2.storage.model.UserEntity;
import com.realcoders.realcoderlinkedinspring2.web.dto.UserDto;
import com.realcoders.realcoderlinkedinspring2.web.dto.UserLoginDto;

import java.util.List;

public interface UserService {
    void register(UserDto userDto);
    UserEntity login(UserLoginDto userLoginDto);
    List<UserEntity> getAll();
}
