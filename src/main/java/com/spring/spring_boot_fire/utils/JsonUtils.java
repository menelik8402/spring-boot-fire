package com.spring.spring_boot_fire.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object object){
        try {
            return objectMapper.writeValueAsString(object);
        }
        catch (Exception e){
            throw  new RuntimeException(e);
        }
    }


    public static <T> T fromJson(String json,Class<T> clazz){
        try {
            return objectMapper.readValue(json,clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
