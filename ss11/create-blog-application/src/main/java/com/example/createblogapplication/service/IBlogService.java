package com.example.createblogapplication.service;

import com.example.createblogapplication.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findALl();
    Page<Blog> findAll(Pageable pageable,String name);

    void add(Blog blog);

    void delete(Blog blog);

    Blog findById(int id);

    void edit(Blog blog);
}
