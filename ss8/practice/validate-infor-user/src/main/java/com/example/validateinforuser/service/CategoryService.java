package com.example.validateinforuser.service;

import com.example.validateinforuser.model.Category;
import com.example.validateinforuser.repository.IRespositoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    IRespositoryCategory respositoryCategory;

    @Override
    public List<Category> findAll() {
        return respositoryCategory.findAll();
    }

    @Override
    public void addCategory(Category category) {
        respositoryCategory.save(category);
    }

    @Override
    public void deleteCategory(Category category) {
        respositoryCategory.delete(category);
    }

    @Override
    public Category selectById(int id) {
        return respositoryCategory.findById(id).orElse(null);
    }

    @Override
    public void editCategory(Category category) {
        respositoryCategory.save(category);
    }
}
