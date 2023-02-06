package com.realcoders.realcoderlinkedinspring2.storage.repository.user;

import com.realcoders.realcoderlinkedinspring2.storage.model.UserEntity;
import com.realcoders.realcoderlinkedinspring2.web.dto.UserDto;


import java.util.List;

public interface UserRepository {
    void save(UserDto userDto);
    boolean containsUsername(UserDto userDto);
    boolean containsEmail(UserDto userDto);
    List<UserEntity> getAll();
}
