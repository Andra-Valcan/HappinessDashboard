package com.example.PCandra.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
@Table(
        name = "choises"
)

public class UserChoise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;

    private Integer answer;

    private String comment;

    private Timestamp dateOfVote;

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDateOfVote(Timestamp dateOfVote) {
        this.dateOfVote = dateOfVote;
    }

    public UserChoise(Integer answer, String comment, Timestamp dateOfVote, User user, Poll poll) {

        this.answer = answer;
        this.comment = comment;
        this.dateOfVote = dateOfVote;
        this.poll=poll;
        this.user=user;
    }

    public UserChoise() {
    }

    public int getId() {
        return id;
    }

    public Long getUser() {
        return user.getId();
    }

    public Long getPoll() {
        return poll.getId();
    }

    public Integer getAnswer() {
        return answer;
    }

    public String getComment() {
        return comment;
    }

    public Timestamp getDateOfVote() {
        return dateOfVote;
    }
}
