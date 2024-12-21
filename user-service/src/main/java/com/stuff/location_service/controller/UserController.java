package com.stuff.location_service.controller;

import com.stuff.location_service.dto.UserCreateRequest;
import com.stuff.location_service.dto.UserDto;
import com.stuff.location_service.model.User;
import com.stuff.location_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping({"api/users"})
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void CreateUser(@RequestBody UserCreateRequest userCreateRequest){
        userService.CreateUser(userCreateRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> GetHouseholds(){
        return userService.GetUsers();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public UserDto GetUser(@PathVariable String id){
        UserDto userDto = userService.GetUser(id);
        return userDto;
    }

    @GetMapping({"/"})
    @ResponseStatus(HttpStatus.OK)
    public UserDto GetUserFromEmail(@RequestParam(value = "email", defaultValue = "") String email) {
        return userService.GetUserFromEmail(email);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteUser(@PathVariable String id){
        userService.DeleteUser(id);
    }

//    @PutMapping({"/{id}"})
//    @ResponseStatus(HttpStatus.CREATED)
//    public void UpdateUser(@PathVariable String id, @RequestBody UserCreateRequest userCreateRequest){
//        userService.CreateUser(id, userCreateRequest);
//    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void UpdateField(@PathVariable String id, @RequestBody String fields){
        userService.UpdateUserField(id, fields);
    }
}