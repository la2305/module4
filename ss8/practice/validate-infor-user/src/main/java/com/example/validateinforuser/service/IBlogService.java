package com.example.validateinforuser.service;

import com.example.validateinforuser.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void addBlog(Blog blog);
    void deleteBlog(int id);
    Blog findById(int id);
    void editBlog(Blog blog);
}
