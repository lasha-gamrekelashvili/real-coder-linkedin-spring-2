package com.realcoders.realcoderlinkedinspring2.storage.repository.user;

import com.realcoders.realcoderlinkedinspring2.storage.model.UserEntity;
import com.realcoders.realcoderlinkedinspring2.web.dto.UserDto;


import java.util.List;

public interface UserRepository {
    UserEntity get(Integer id);

    UserEntity getByUsername(String username);
    UserEntity getByEmail(String email);
    List<UserEntity> getAll();

    void insert(UserEntity userEntity);

    void delete(Integer id);

    void update(Integer id, UserEntity userEntity);

    boolean containsId(Integer id);

    boolean containsUsername(String username);

    boolean containsEmail(String username);
    boolean containsEntity(UserEntity userEntity);
}
