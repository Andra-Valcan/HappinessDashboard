package com.example.PCandra.mapper;

import com.example.PCandra.dtos.UserDto;
import com.example.PCandra.entity.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserMapper {
    public static User toEntity(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public static UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public static List<UserDto> toDtoList(List<User> usersList) {
        List<UserDto> userDtoList = new ArrayList<>();
        Iterator<User> it = usersList.iterator();
        while(it.hasNext()){
            UserDto s = toDto(it.next());
            userDtoList.add(s);
        }
        return userDtoList;
    }


}
