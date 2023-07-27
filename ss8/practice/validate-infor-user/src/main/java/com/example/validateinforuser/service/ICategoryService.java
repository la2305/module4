package com.example.validateinforuser.service;

import com.example.validateinforuser.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void addCategory(Category category);
    void deleteCategory(Category category);
    Category selectById(int id);
    void editCategory(Category category);
}
