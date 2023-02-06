package com.realcoders.realcoderlinkedinspring2.storage.repository.user;

import com.realcoders.realcoderlinkedinspring2.core.db.InMemoryDb;
import com.realcoders.realcoderlinkedinspring2.storage.model.UserEntity;
import com.realcoders.realcoderlinkedinspring2.web.dto.UserDto;
import com.realcoders.realcoderlinkedinspring2.web.transformer.UserTransformer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @Override
    public void save(UserDto userDto) {
        InMemoryDb.insert(UserTransformer.fromDto(userDto));
    }

    @Override
    public boolean containsUsername(UserDto userDto) {
        return InMemoryDb.containsUsername(userDto.getUsername());
    }

    @Override
    public boolean containsEmail(UserDto userDto) {
        return InMemoryDb.containsUsername(userDto.getEmail());
    }

    @Override
    public List<UserEntity> getAll() {
        return InMemoryDb.getAll();
    }
}
