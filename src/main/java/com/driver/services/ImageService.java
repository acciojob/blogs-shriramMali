package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;

    public Image createAndReturn(Blog blog, String description, String dimensions){
        //create an image based on given parameters and add it to the imageList of given blog
        Image image=new Image();
        image.setDimension(dimensions);
        image.setDescription(description);

        List<Image> imageList=new ArrayList<>();
        imageList=blog.getBlogsImages();
        imageList.add(image);
        blog.setBlogsImages(imageList);

        return image;
    }

    public void deleteImage(Image image){
   imageRepository2.delete(image);
    }

    public Image findById(int id) {
        Image image=imageRepository2.findById(id).get();
        return image;
    }

    public int countImagesInScreen(Image image, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        int count=0;
        int diamension=(Integer.parseInt( image.getDimension()));

        if(image!=null && diamension!=0){

         count=Integer.parseInt(screenDimensions)/diamension;

        }
      return count;

        //In case the image is null, return 0
    }
}
