
package com.driver.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;

    private String title;

    private Date pubDate;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    private List<Image> imageList;

    public Blog() {
    }
    public Blog(String title, String content) {
        this.content = content;
        this.title = title;
    }
/*
    public Blog(String content, String title, Date pubDate, User user, List<Image> imageList) {
        this.content = content;
        this.title = title;
        this.pubDate = pubDate;
        this.user = user;
        this.imageList = imageList;
    } */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}