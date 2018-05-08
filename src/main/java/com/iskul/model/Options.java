package com.iskul.model;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "options")
public class Options implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "option_text")
    private String option;


    @ManyToOne
    @JoinColumn(name = "question_id",referencedColumnName = "id")
    private Questions questions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public Options(String option, Questions questions) {
        this.option = option;
        this.questions = questions;
    }

    public Options() {
    }
}
