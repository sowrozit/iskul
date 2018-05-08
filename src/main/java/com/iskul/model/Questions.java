package com.iskul.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Sowrozit on 3/7/2017.
 */

@Entity
@Table(name = "QUESTIONS")
public class Questions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String question;

    @OneToOne(fetch = FetchType.EAGER,mappedBy ="questions")
    private Answers answers;


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "questions")
    private Collection<Options> options = new ArrayList<Options>();


    @ManyToOne
    @NotNull
    @JoinColumn(name = "topic_id" , referencedColumnName = "id",nullable = false)
    private Topic topic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
    }

    public Collection<Options> getOptions() {
        return options;
    }

    public void setOptions(Collection<Options> options) {
        this.options = options;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
