package com.realcoders.realcoderlinkedinspring2.service.user;

import com.realcoders.realcoderlinkedinspring2.storage.model.UserEntity;
import com.realcoders.realcoderlinkedinspring2.web.dto.UserDto;

import java.util.List;

public interface UserService {
    void register(UserDto userDto);
    List<UserEntity> getAll();
}
