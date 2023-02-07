package com.realcoders.realcoderlinkedinspring2.service.user;

import com.realcoders.realcoderlinkedinspring2.storage.model.UserEntity;
import com.realcoders.realcoderlinkedinspring2.web.dto.UserRegistrationDto;
import com.realcoders.realcoderlinkedinspring2.web.dto.UserLoginDto;

import java.util.List;

public interface UserService {
    void register(UserRegistrationDto userRegistrationDto);
    UserEntity login(UserLoginDto userLoginDto);
    List<UserEntity> getAll();
}
