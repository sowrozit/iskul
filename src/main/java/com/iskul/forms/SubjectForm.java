package com.iskul.forms;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Sowrozit on 3/2/2017.
 */
public class SubjectForm {
    @NotEmpty
    private String sub_title;

    @NotNull
    private int category;

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
