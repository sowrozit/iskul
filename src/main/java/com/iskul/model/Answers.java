package com.iskul.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sowrozit on 3/7/2017.
 */

@Entity
@Table(name = "ANSWERS")
public class Answers implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "question_id" ,referencedColumnName = "id",nullable = false)
    private Questions questions;

    @OneToOne
    @JoinColumn(name = "option_id",referencedColumnName = "id",nullable = false)
    private Options options;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public Answers(Questions questions, Options options) {
        this.questions = questions;
        this.options = options;
    }

    public Answers() {
    }
}
