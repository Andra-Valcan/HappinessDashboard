package com.example.PCandra.dtos;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserDto {

    private Long id;
    private String name;
    private String password;

    public UserDto(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    public  UserDto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
