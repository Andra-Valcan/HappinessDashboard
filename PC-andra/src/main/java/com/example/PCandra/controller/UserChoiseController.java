package com.example.PCandra.controller;

import com.example.PCandra.dtos.UserChoiseDto;
import com.example.PCandra.entity.UserChoise;
import com.example.PCandra.repository.UserChoiseRepository;
import com.example.PCandra.service.UserChoiseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserChoiseController {
    private final UserChoiseService userChoiseService;
    private final UserChoiseRepository userChoiseRepository;

    public UserChoiseController(UserChoiseService userChoiseService, UserChoiseRepository userChoiseRepository) {
        this.userChoiseService = userChoiseService;
        this.userChoiseRepository = userChoiseRepository;
    }


    @GetMapping("/choise")
    public List<UserChoise> getUsersChoise(){
        return userChoiseService.getUsersChoises();

    }

    @PostMapping(value = "/newChoise")
    public void addChoise(@RequestBody UserChoiseDto userChoiseDto){
        System.out.println(userChoiseDto.getAnswer());
        UserChoise uc=new UserChoise();
        uc.setAnswer(userChoiseDto.getAnswer());
        uc.setId(1);
        UserChoise addedPollDto = userChoiseRepository.save(uc);

    }
}
