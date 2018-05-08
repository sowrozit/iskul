package com.iskul.forms;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Sowrozit on 3/6/2017.
 */
public class CategoryForm {

    @NotEmpty
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
