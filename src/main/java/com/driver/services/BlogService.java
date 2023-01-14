package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    ImageService imageService1;

    @Autowired
    UserRepository userRepository1;

    public List<Blog> showBlogs(){
        //find all blogs
        List<Blog> newList=blogRepository1.findAll();
        return newList;
    }

    public void createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time

         Blog blog=new Blog();
         blog.setContent(content);
         blog.setTitle(title);
         blog.setId(userId);
        //updating the blog details

        User user=userRepository1.findById(userId).get();
        List<Blog> userBlogs=user.getBlogList();
        userBlogs.add(blog);

        user.setBlogList(userBlogs);
        //Updating the userInformation and changing its blogs

         userRepository1.save(user);
    }

    public Blog findBlogById(int blogId){
       Blog blog=blogRepository1.findById(blogId).get();
       return blog;
    }

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it



        Image newImage=new Image();
        newImage.setDescription(description);
        newImage.setDimensions(dimensions);




        Blog blog=blogRepository1.findById(blogId).get();
        List<Image> newSet=blog.getImageList();
        newSet.add(newImage);

        newImage.setBlog(blog);

        blog.setImageList(newSet);

       blogRepository1.save(blog);

    }

    public void deleteBlog(int blogId){
        blogRepository1.deleteById(blogId);
        //delete blog and corresponding images
    }
}
