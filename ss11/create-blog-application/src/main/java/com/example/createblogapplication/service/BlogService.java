package com.example.createblogapplication.service;

import com.example.createblogapplication.model.Blog;
import com.example.createblogapplication.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository BlogRepository;

    @Override
    public List<Blog> findALl() {
        return BlogRepository.findAll();
    }
    public Page<Blog> findAll(Pageable pageable,String name){
        return BlogRepository.findBlogByNameContaining(pageable,name);
    }

    @Override
    public void add(Blog blog) {
        BlogRepository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
        BlogRepository.delete(blog);
    }

    @Override
    public Blog findById(int id) {
        return BlogRepository.findById(id).orElse(null);
    }

    @Override
    public void edit(Blog blog) {
        BlogRepository.save(blog);
    }
}