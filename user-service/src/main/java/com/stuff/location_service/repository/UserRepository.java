package com.stuff.location_service.repository;

import com.stuff.location_service.model.User;

import java.util.List;
import java.util.Map;

public interface UserRepository {
    List<User> FindAllUsers();

    User FindUser(String id);

    void CreateUser(User user);

    void DeleteUser(User user);

    void UpdateUser(User user, User newUser);

    User FindUserFromEmail(String email);
}
