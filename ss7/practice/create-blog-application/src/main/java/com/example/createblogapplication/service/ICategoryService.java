package com.example.createblogapplication.service;

import com.example.createblogapplication.model.Blog;
import com.example.createblogapplication.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findALl();
    Page<Category> findAll(Pageable pageable, String name);
    void add(Category category);

    void delete(int id);

    Category findById(int id);
    void edit(Category category);

}