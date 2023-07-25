package com.example.createblogapplication.service;

import com.example.createblogapplication.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findALl();

    void add(Blog blog);

    void delete(Blog blog);

    Blog findById(int id);

    void edit(Blog blog);
}
