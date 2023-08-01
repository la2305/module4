package com.example.createblogapplication.controller;

import com.example.createblogapplication.model.Blog;
import com.example.createblogapplication.model.Category;
import com.example.createblogapplication.service.IBlogService;
import com.example.createblogapplication.service.ICategoryService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getList() {
        List<Blog> blogList = blogService.findALl();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> detail(@PathVariable int id){
        Blog blog = blogService.findById(id);
        if (blog==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Blog blog){
        blogService.add(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Blog> delete(@RequestParam int id){
        Blog blog = blogService.findById(id);
        if (blog==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        blogService.delete(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete1/{id}")
    public ResponseEntity<Blog> delete1(@PathVariable int id){
        Blog blog = blogService.findById(id);
        if (blog==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        blogService.delete(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    @PutMapping("/edit/{id}")
//    public ResponseEntity<Blog> update(@PathVariable int id,@RequestBody Blog blog){
//        Blog blog1 = blogService.findById(id);
//        if (blog1==null){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        blogService.edit(blog);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}

