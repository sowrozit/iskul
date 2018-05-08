package com.iskul.forms;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Sowrozit on 3/7/2017.
 */
public class QuestionsForm {


    int id = 0;

    @NotEmpty(message = "show error")
    private String question;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    private int topic;

    @NotEmpty
    private String option1;

    @NotEmpty
    private String option2;

    @NotEmpty
    private String option3;
    @NotEmpty
    private String option4;


    @NotEmpty
    private String correctAnswer;




    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getTopic() {
        return topic;
    }

    public void setTopic(int topic) {
        this.topic = topic;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

}
