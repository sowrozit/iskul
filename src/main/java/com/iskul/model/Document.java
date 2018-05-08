//package com.iskul.model;
//
//import com.sun.istack.NotNull;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.sql.Blob;
//
///**
// * Created by Sowrozit on 5/5/2017.
// */
//@Entity
//@Table(name = "DOCUMENTS")
//public class Document implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//
//    @Column
//    private String filename;
//
//    @Column
//    @Lob
//    private Blob content;
//
//    @Column
//    private String content_type;
//
//    @OneToOne
//    @NotNull
//    @JoinColumn(name = "topic_id" , referencedColumnName = "id", nullable = false)
//    private Topic topic;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getFilename() {
//        return filename;
//    }
//
//    public void setFilename(String filename) {
//        this.filename = filename;
//    }
//
//    public Blob getContent() {
//        return content;
//    }
//
//    public void setContent(Blob content) {
//        this.content = content;
//    }
//
//    public String getContent_type() {
//        return content_type;
//    }
//
//    public void setContent_type(String content_type) {
//        this.content_type = content_type;
//    }
//
//    public Topic getTopic() {
//        return topic;
//    }
//
//    public void setTopic(Topic topic) {
//        this.topic = topic;
//    }
//}
