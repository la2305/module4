package com.example.createblogapplication.service;

import com.example.createblogapplication.model.Blog;
import com.example.createblogapplication.model.Category;
import com.example.createblogapplication.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findALl() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable, String name) {
        return categoryRepository.findCategoryByNameContaining(pageable,name);
    }

    @Override
    public void add(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void edit(Category category) {
        categoryRepository.save(category);
    }
}