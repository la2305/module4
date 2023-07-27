package com.example.student.repository;

import com.example.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findStudentByNameContainingAndGender(String name, int gender);
}
