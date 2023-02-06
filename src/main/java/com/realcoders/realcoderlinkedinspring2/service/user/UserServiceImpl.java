package com.realcoders.realcoderlinkedinspring2.service.user;

import com.realcoders.realcoderlinkedinspring2.core.exception.AppException;
import com.realcoders.realcoderlinkedinspring2.storage.model.UserEntity;
import com.realcoders.realcoderlinkedinspring2.storage.repository.user.UserRepository;
import com.realcoders.realcoderlinkedinspring2.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public void register(UserDto userDto) {
        if(userRepository.containsEmail(userDto) || userRepository.containsUsername(userDto)){
            throw new AppException("The specified username or email already exists", HttpStatus.CONFLICT);
        }
        userRepository.save(userDto);
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.getAll();
    }
}
