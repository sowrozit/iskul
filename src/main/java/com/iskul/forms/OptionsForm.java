package com.iskul.forms;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Sowrozit on 3/7/2017.
 */
public class OptionsForm {

    @NotEmpty
    private String option;

    @NotNull
    private int questions;

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getQuestions() {
        return questions;
    }

    public void setQuestions(int questions) {
        this.questions = questions;
    }
}
