package com.example.createblogapplication.service;

import com.example.createblogapplication.model.Blog;
import com.example.createblogapplication.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findALl() {
        return iBlogRepository.findAll();
    }

    @Override
    public void add(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
        iBlogRepository.delete(blog);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void edit(Blog blog) {
        iBlogRepository.save(blog);
    }
}