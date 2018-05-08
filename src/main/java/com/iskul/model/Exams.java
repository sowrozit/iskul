package com.iskul.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Sowrozit on 4/10/2017.
 */
@Entity
@Table(name = "EXAMS")
public class Exams implements Serializable {

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
    private String unique_id;

    @Column
    private Date start_time;

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

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }
}
