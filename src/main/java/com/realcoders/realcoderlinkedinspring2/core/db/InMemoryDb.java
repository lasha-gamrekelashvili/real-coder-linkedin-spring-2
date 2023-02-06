package com.realcoders.realcoderlinkedinspring2.core.db;

import com.realcoders.realcoderlinkedinspring2.storage.model.UserEntity;

import java.util.*;

public class InMemoryDb {
    private static int index;
    private static final Map<Integer,String> usernames = new HashMap<>();

    private static final Map<Integer,String> emails = new HashMap<>();
    private static final Map<Integer, UserEntity> storage = new HashMap<>();

    public static UserEntity get(Integer id){
        return storage.get(id);
    }

    public static List<UserEntity> getAll(){
        return storage.values().stream().toList();
    }

    public static void insert(UserEntity userEntity){
        userEntity.setId(index);

        usernames.put(index,userEntity.getUsername());
        emails.put(index,userEntity.getEmail());

        storage.put(index++,userEntity);
    }

    public static void delete(Integer id){
        usernames.remove(id);
        emails.remove(id);
        storage.remove(index--);
    }

    public static void update(Integer id, UserEntity userEntity){
        usernames.put(id,userEntity.getUsername());
        emails.put(id,userEntity.getEmail());
        storage.put(id,userEntity);
    }

    public static boolean containsId(Integer id){
        return storage.containsKey(id);
    }

    public static boolean containsUsername(String username){
        return usernames.containsValue(username);
    }

    public static boolean containsEmail(String username){
        return emails.containsValue(username);
    }
    public static boolean containsEntity(UserEntity userEntity){
        return storage.containsValue(userEntity);
    }
}
