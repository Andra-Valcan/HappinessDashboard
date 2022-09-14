package com.example.PCandra.service;

import com.example.PCandra.dtos.PollDto;
import com.example.PCandra.dtos.UserChoiseDto;
import com.example.PCandra.entity.Poll;
import com.example.PCandra.entity.UserChoise;
import com.example.PCandra.exception.CustomException;
import com.example.PCandra.mapper.PollMapper;
import com.example.PCandra.mapper.UserChoiseMapper;
import com.example.PCandra.repository.UserChoiseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserChoiseService {
    private final UserChoiseRepository userChoiseRepository;

    public UserChoiseService(UserChoiseRepository userChoiseRepository) {
        this.userChoiseRepository = userChoiseRepository;
    }

    public List<UserChoise> getUsersChoises(){
        return userChoiseRepository.findAll();
    }



}
