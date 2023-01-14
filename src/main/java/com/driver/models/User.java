package com.driver.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;

    private String password;

    private String lastName;

    private String firstName;

    public User() {
    }

    public User( String userName, String password, String lastName, String firstName) {
        this.userName = userName;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
    }


    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<Blog> userBlogs;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}