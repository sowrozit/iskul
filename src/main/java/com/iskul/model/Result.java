package com.iskul.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Sowrozit on 4/10/2017.
 */

@Entity
@Table(name = "RESULT")
public class Result implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id",nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "topic_id",referencedColumnName = "id",nullable = false)
    private Topic topic;

    @Column
    private int full_marks;

    @Column
    private int earned_marks;

    @Column
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public int getFull_marks() {
        return full_marks;
    }

    public void setFull_marks(int full_marks) {
        this.full_marks = full_marks;
    }

    public int getEarned_marks() {
        return earned_marks;
    }

    public void setEarned_marks(int earned_marks) {
        this.earned_marks = earned_marks;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
