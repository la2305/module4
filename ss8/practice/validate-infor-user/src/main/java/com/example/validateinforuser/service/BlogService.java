package com.example.validateinforuser.service;

import com.example.validateinforuser.model.Blog;
import com.example.validateinforuser.repository.IRepositoryBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService{
    @Autowired
    private IRepositoryBlog repositoryBlog;
    @Override
    public List<Blog> findAll() {
        return repositoryBlog.findAll();
    }

    @Override
    public void addBlog(Blog blog) {
        repositoryBlog.save(blog);
    }

    @Override
    public void deleteBlog(int id) {
        repositoryBlog.deleteById(id);
    }

    @Override
    public Blog findById(int id) {
        return repositoryBlog.findById(id).orElse(null);
    }

    @Override
    public void editBlog(Blog blog) {
        repositoryBlog.save(blog);
    }
}
