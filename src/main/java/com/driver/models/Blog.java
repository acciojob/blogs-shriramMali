
package com.driver.models;
import com.driver.models.User;

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

    private Date date;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    private List<Image> blogsImages;

    public Blog() {

    }

    public Blog(String content, String title, Date date, User user, List<Image> blogsImages) {
        this.content = content;
        this.title = title;
        this.date = date;
        this.user = user;
        this.blogsImages = blogsImages;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getBlogsImages() {
        return blogsImages;
    }

    public void setBlogsImages(List<Image> blogsImages) {
        this.blogsImages = blogsImages;
    }
}