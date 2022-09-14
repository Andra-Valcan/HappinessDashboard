package com.example.PCandra.dtos;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class PollDto {

    private Long id;
    private String question;
    private String topic;
    private Boolean active;
    private Timestamp creationDate;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date expirationDate;
    private String keywords;
    public PollDto(Long id, String question, String topic, Boolean active, Timestamp creationDate, Date expirationDate) {
        this.id = id;
        this.question = question;
        this.topic = topic;
        this.active = active;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords() {
        this.keywords = keywords;
    }

    public PollDto(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
