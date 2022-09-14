package com.example.PCandra.dtos;

import com.example.PCandra.entity.Poll;
import com.example.PCandra.entity.User;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

public class UserChoiseDto {

    private int id;
    private Integer answer;
    private String comment;
    private Timestamp dateOfVote;

    public UserChoiseDto(int id, Integer answer, String comment, Timestamp dateOfVote) {
        this.id = id;
        this.answer = answer;
        this.comment = comment;
        this.dateOfVote = dateOfVote;
    }

    public UserChoiseDto(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getDateOfVote() {
        return dateOfVote;
    }

    public void setDateOfVote(Timestamp dateOfVote) {
        this.dateOfVote = dateOfVote;
    }
}
