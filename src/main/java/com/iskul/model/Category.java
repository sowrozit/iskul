package com.iskul.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sowrozit on 2/27/2017.
 */
@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String title;


    //    @OneToOne
//    @JoinColumn(name = "id")
//    private Subject subject;
//
//    public Subject getSubject() {
//        return subject;
//    }
//
//    public void setSubject(Subject subject) {
//        this.subject = subject;
//    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title=title;
    }
}
