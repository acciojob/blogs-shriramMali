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

     /*    Blog blog=new Blog();
         blog.setContent(content);
         blog.setTitle(title);
         blog.setPubDate(new Date());

        User user=userRepository1.findById(userId).get();
        blog.setUser(user);
        //updating the blog details

        List<Blog> userBlogs=user.getBlogList();
        userBlogs.add(blog);

        user.setBlogList(userBlogs);
        //Updating the userInformation and changing its blogs
       // blogRepository1.save(blog);
         userRepository1.save(user);*/

        User user=userRepository1.findById(userId).get();

        Blog blog=new Blog(title,content);

        blog.setUser(user);

        List<Blog> blogList=user.getBlogList();
        blogList.add(blog);
        user.setBlogList(blogList);

        userRepository1.save(user);
    }

    public Blog findBlogById(int blogId){
       Blog blog=blogRepository1.findById(blogId).get();
       return blog;
    }

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it

        Blog blog=blogRepository1.findById(blogId).get();

        Image image=imageService1.createAndReturn(blog,description,dimensions);

        image.setBlog(blog);

        List<Image> imageList=blog.getImageList();
        if(imageList==null) imageList=new ArrayList<>();
        imageList.add(image);
        blog.setImageList(imageList);

        blogRepository1.save(blog);
      /*  Blog blog=blogRepository1.findById(blogId).get();

        Image newImage=new Image();
        newImage.setDescription(description);
        newImage.setDimensions(dimensions);
        newImage.setBlog(blog);

        List<Image> newSet=blog.getImageList();
        newSet.add(newImage);

        blog.setImageList(newSet);

       blogRepository1.save(blog);*/

    }

    public void deleteBlog(int blogId){
        if(blogRepository1.findById(blogId).get()==null) return;
        blogRepository1.deleteById(blogId);
        //delete blog and corresponding images
    }
}
