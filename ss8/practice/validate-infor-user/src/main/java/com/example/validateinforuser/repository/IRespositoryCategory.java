package com.example.validateinforuser.repository;

import com.example.validateinforuser.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRespositoryCategory extends JpaRepository<Category,Integer> {
}
