package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    @Autowired
    BlogService blogService3;

    public void createUser(User user){
        userRepository3.save(user);
    }

    public void deleteUser(int userId){
        userRepository3.deleteById(userId);
    }

    public void updateUser(User user){
        userRepository3.save(user);
    }

    public User findUser(String username){
    Iterator<User> n=userRepository3.findAll().iterator();
        for (Iterator<User> it = n; it.hasNext(); ) {
            User user = it.next();
            if(user.getUsername().equals(username)) return user;
        }
 return null;
    }

    public User findUserByUsername(String username){

        return userRepository3.findUser(username);
    }
}
