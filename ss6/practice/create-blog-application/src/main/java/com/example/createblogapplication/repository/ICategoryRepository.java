package com.example.createblogapplication.repository;

import com.example.createblogapplication.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
