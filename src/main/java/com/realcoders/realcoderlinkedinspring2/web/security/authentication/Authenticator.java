package com.realcoders.realcoderlinkedinspring2.web.security.authentication;

import com.realcoders.realcoderlinkedinspring2.storage.model.UserEntity;

public interface Authenticator {
    UserEntity verify(String idTokenString);
}
