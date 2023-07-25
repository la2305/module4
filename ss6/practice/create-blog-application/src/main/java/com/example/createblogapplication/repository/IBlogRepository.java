package com.example.createblogapplication.repository;

import com.example.createblogapplication.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
}
