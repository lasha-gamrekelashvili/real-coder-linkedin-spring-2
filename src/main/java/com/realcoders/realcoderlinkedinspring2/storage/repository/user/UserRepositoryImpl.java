package com.realcoders.realcoderlinkedinspring2.storage.repository.user;

import com.realcoders.realcoderlinkedinspring2.storage.model.UserEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Repository
public class UserRepositoryImpl implements UserRepository{

    private static int index;
    private static final Map<String,Integer> usernames = new HashMap<>();

    private static final Map<String,Integer> emails = new HashMap<>();
    private static final Map<Integer, UserEntity> storage = new HashMap<>();

    @Override
    public  UserEntity get(Integer id){
        return storage.get(id);
    }

    @Override
    public  UserEntity getByUsername(String username){
        Integer id = usernames.get(username);
        return storage.get(id);
    }

    @Override
    public UserEntity getByEmail(String email) {
        Integer id = emails.get(email);
        return storage.get(id);
    }

    public  List<UserEntity> getAll(){
        return storage.values().stream().toList();
    }
    @Override
    public  void insert(UserEntity userEntity){
        userEntity.setId(index);

        usernames.put(userEntity.getUsername(),index);
        emails.put(userEntity.getEmail(),index);

        storage.put(index++,userEntity);

        log.info(storage);
    }
    @Override
    public  void delete(Integer id){
        usernames.remove(get(id).getUsername());
        emails.remove(get(id).getEmail());
        storage.remove(index--);
    }
    @Override
    public  void update(Integer id, UserEntity userEntity){
        usernames.put(userEntity.getUsername(),id);
        emails.put(userEntity.getEmail(),id);
        storage.put(id,userEntity);
    }
    @Override
    public  boolean containsId(Integer id){
        return storage.containsKey(id);
    }
    @Override
    public  boolean containsUsername(String username){
        return usernames.containsKey(username);
    }
    @Override
    public  boolean containsEmail(String username){
        return emails.containsKey(username);
    }
    @Override
    public  boolean containsEntity(UserEntity userEntity){
        return storage.containsValue(userEntity);
    }
}
