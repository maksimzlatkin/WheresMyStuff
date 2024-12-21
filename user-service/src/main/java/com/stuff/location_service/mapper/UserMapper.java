package com.stuff.location_service.mapper;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stuff.location_service.dto.UserCreateRequest;
import com.stuff.location_service.dto.UserDto;
import com.stuff.location_service.model.User;

import java.io.IOException;

public class UserMapper {

    ObjectMapper objectMapper = new ObjectMapper();

    public User toUser(UserDto userDTO){
        return new User(userDTO.getId(), userDTO.getEmail(), userDTO.getName());
    }

    public User toUser(UserCreateRequest userCreateRequest, String id){
        return new User(id, userCreateRequest.getEmail(), userCreateRequest.getName());
    }

    public UserDto toUserDto(User user){
        return new UserDto(user.getId(), user.getEmail(), user.getName());
    }

    public User toUserFromJson(String id, String field) {
        try {
            UserCreateRequest userCreateRequest = objectMapper.readValue(field, UserCreateRequest.class);
            return User.builder().id(id).email(userCreateRequest.getEmail()).name(userCreateRequest.getName()).build();
        }catch (IOException e){
            return null;
        }
    }
}
