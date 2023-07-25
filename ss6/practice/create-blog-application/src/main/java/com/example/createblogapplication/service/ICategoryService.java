package com.example.createblogapplication.service;

import com.example.createblogapplication.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findALl();

    void add(Category category);

    void delete(int id);

    Category findById(int id);

}