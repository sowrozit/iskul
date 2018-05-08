package com.iskul.forms;

import com.sun.istack.NotNull;

/**
 * Created by Sowrozit on 3/7/2017.
 */
public class AnswersForm {

    @NotNull
    private int questions;

    @NotNull
    private int options;

    public int getQuestions() {
        return questions;
    }

    public void setQuestions(int questions) {
        this.questions = questions;
    }

    public int getOptions() {
        return options;
    }

    public void setOptions(int options) {
        this.options = options;
    }
}
