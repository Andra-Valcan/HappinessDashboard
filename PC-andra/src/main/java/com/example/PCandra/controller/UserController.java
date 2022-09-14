package com.example.PCandra.controller;

import com.example.PCandra.dtos.UserDto;
import com.example.PCandra.entity.User;
import com.example.PCandra.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    private final UserService userService;

    public UserController( UserService userService) {
        this.userService = userService;

    }

    @GetMapping(value = "/allUsers")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }


    @GetMapping(value = "/user/{idd}")
    public UserDto getUser(@PathVariable("idd") Long id){
        return userService.getUserById(id);
    }

    @PostMapping(value = "newUser")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        UserDto result = userService.addUser(userDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


}
