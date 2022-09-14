package com.example.PCandra.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(
        name = "poll"
)
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    private String topic;

    private Boolean active;

    private Timestamp creationDate;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date expirationDate;

    private String keywords;

    @OneToMany(
            mappedBy = "poll",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<UserChoise> usersChoise ;

    public Poll(String question, String topic, Boolean active, Timestamp creationDate, java.sql.Date expirationDate, String keywords, User owner) {
        this.creationDate = creationDate;
        this.question = question;
        this.topic = topic;
        this.active = active;
        this.expirationDate = expirationDate;
        this.owner = owner;
        this.keywords = keywords;
    }

    public Poll() {
        this.creationDate = new Timestamp(System.currentTimeMillis());
        this.active = true;
       // this.expirationDate = new Timestamp(System.currentTimeMillis());;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void addUsers(UserChoise choise){
        usersChoise.add(choise);
    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public Long getOwner() {
        return owner.getId();
    }

    public String getTopic() {
        return topic;
    }

    public Boolean getActive() {
        return active;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }



    public void setQuestion(String question) {
        this.question = question;
    }


    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }


}
