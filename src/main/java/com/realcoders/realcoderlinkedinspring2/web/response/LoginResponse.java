package com.realcoders.realcoderlinkedinspring2.web.response;

import java.util.HashMap;
import java.util.Map;

public class LoginResponse {
    public static Map<String,String> of(String message){
        Map<String,String> response = new HashMap<>();
        response.put("token",message);

        return response;
    }
}
