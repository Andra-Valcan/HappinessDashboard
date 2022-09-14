package com.example.PCandra;

import com.example.PCandra.entity.Poll;
import com.example.PCandra.entity.User;
import com.example.PCandra.entity.UserChoise;
import com.example.PCandra.repository.PollRepository;
import com.example.PCandra.repository.UserChoiseRepository;
import com.example.PCandra.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PcAndraApplication {

	public static void main(String[] args) {
		SpringApplication.run(PcAndraApplication.class, args);
	}

}
