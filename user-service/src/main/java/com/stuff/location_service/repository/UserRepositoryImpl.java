package com.stuff.location_service.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stuff.location_service.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private List<User> list;
    public UserRepositoryImpl() {
        list = new ArrayList<User>();
        list.add(User.builder()
                .id(UUID.randomUUID().toString())
                .email("somegmail@gmail.com")
                .name("John Doe").build());
        list.add(User.builder()
                .id(UUID.randomUUID().toString())
                .email("random@gmail.com")
                .name("Jinky Minus").build());
    }

    public List<User> FindAllUsers(){
        return list;
    }

    public User FindUser(String id){
        for (User user : list){
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void DeleteUser(User user) {
        if (list.contains(user)) {
            list.remove(user);
        }
    }

    public void CreateUser(User user){
        list.add(user);
    }

    public void UpdateUser(User user, User newUser){
        user.setEmail(newUser.getEmail());
        user.setName(newUser.getName());
    }

    public User FindUserFromEmail(String email) {
        for (User user : list){
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}
