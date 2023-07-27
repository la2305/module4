package com.example.validateinforuser.repository;

import com.example.validateinforuser.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryBlog extends JpaRepository<Blog,Integer> {
}
