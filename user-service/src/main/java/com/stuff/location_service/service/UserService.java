package com.stuff.location_service.service;

import com.stuff.location_service.dto.UserCreateRequest;
import com.stuff.location_service.dto.UserDto;
import com.stuff.location_service.mapper.UserMapper;
import com.stuff.location_service.model.User;
import com.stuff.location_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.stuff.exception.EntityNotFoundException;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    UserMapper mapper = new UserMapper();

    public void CreateUser(UserCreateRequest householdCreateRequest){
        userRepository.CreateUser(mapper.toUser(householdCreateRequest, UUID.randomUUID().toString()));
    }

    public List<UserDto> GetUsers(){
        List<UserDto> users = new ArrayList<UserDto>();
        for (User user : userRepository.FindAllUsers()) {
            users.add(mapper.toUserDto(user));
        }
        return users;
    }

    public UserDto GetUser(String id){
        User user = GetUserOrThrowException(id);
        return mapper.toUserDto(user);
    }

    public UserDto GetUserFromEmail(String email){
        User user = GetUserFromEmailOrThrowException(email);
        return mapper.toUserDto(user);
    }

    public void DeleteUser(String id){
        User user = GetUserOrThrowException(id);
        userRepository.DeleteUser(user);
    }

    public void UpdateUser(String id, UserCreateRequest userCreateRequest){
//        CreateUser(User);
    }

    public void UpdateUserField(String id, String fields) {
        User user = GetUserOrThrowException(id);
        User newUser = mapper.toUserFromJson(id, fields);
        userRepository.UpdateUser(user, newUser);
    }

    private User GetUserOrThrowException(String id){
        User user = userRepository.FindUser(id);
        if (user == null) {
            throw new EntityNotFoundException(String.format("User with id='%s' not found", id));
        }
        return user;
    }

    private User GetUserFromEmailOrThrowException(String email){
        User user = userRepository.FindUserFromEmail(email);
        if (user == null) {
            throw new EntityNotFoundException(String.format("User with email='%s' not found", email));
        }
        return user;
    }
}
