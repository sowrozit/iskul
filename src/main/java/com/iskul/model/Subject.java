package com.iskul.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sowrozit on 2/27/2017.
 */
@Entity
@Table(name = "SUBJECT")
public class Subject implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String sub_title;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public String getSub_title()
    {
        return sub_title;
    }
    public void setSub_title(String sub_title)
    {
        this.sub_title=sub_title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
