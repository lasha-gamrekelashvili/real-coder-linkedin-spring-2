package com.realcoders.realcoderlinkedinspring2.web.response;

import java.util.HashMap;
import java.util.Map;

public class BasicResponse {

    public static Map<String,String> of(String message){
        Map<String,String> response = new HashMap<>();
        response.put("message",message);

        return response;
    }
}
