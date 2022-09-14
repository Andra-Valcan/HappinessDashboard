package com.example.PCandra.service;

import com.example.PCandra.dtos.UserDto;
import com.example.PCandra.entity.User;
import com.example.PCandra.mapper.UserMapper;
import com.example.PCandra.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserDto> userDtoList = UserMapper.toDtoList(users);
        return userDtoList;

    }

    public UserDto addUser(UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        UserDto userDto1 = UserMapper.toDto(userRepository.save(user));
        return userDto1;

    }

    public UserDto getUserById(Long id) {
        User user = userRepository.getById(id);
        UserDto userDto = UserMapper.toDto(user);
        return userDto;
    }

}
