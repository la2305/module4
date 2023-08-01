package com.example.createblogapplication.controller;

import com.example.createblogapplication.model.Blog;
import com.example.createblogapplication.model.Category;
import com.example.createblogapplication.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RestCategoryController {
    @Autowired
    ICategoryService categoryService;
    @GetMapping("/category")
    public ResponseEntity<List<Category>> getListCategory(){
        List<Category> categoryList = categoryService.findALl();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }
    @GetMapping("/blogsList/{id}")
    public ResponseEntity<Set<Blog>> showCategory(@PathVariable int id){
        Category category = categoryService.findById(id);
        Set<Blog> blogList = category.getBlogSet();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

}
