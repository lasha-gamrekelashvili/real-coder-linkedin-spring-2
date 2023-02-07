package com.realcoders.realcoderlinkedinspring2.service.user;

import com.realcoders.realcoderlinkedinspring2.core.AppException;
import com.realcoders.realcoderlinkedinspring2.storage.model.UserEntity;
import com.realcoders.realcoderlinkedinspring2.storage.repository.user.UserRepository;
import com.realcoders.realcoderlinkedinspring2.web.dto.UserRegistrationDto;
import com.realcoders.realcoderlinkedinspring2.web.dto.UserLoginDto;
import com.realcoders.realcoderlinkedinspring2.web.transformer.UserTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public void register(UserRegistrationDto userRegistrationDto) {
        if(userRepository.containsEmail(userRegistrationDto.getPassword()) || userRepository.containsUsername(userRegistrationDto.getUsername())){
            throw new AppException("The specified username or email already exists", HttpStatus.CONFLICT);
        }
        userRepository.insert(UserTransformer.fromDto(userRegistrationDto));
    }

    @Override
    public UserEntity login(UserLoginDto userLoginDto) {
        UserEntity userEntity = userRepository.getByUsername(userLoginDto.getUsername());

        if(!userEntity.getPassword().equals(userLoginDto.getPassword())){
            throw new AppException("Incorrect username or password", HttpStatus.UNAUTHORIZED);
        }

        return userEntity;
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.getAll();
    }
}
