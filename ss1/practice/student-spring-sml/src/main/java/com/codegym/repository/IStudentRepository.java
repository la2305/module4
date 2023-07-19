package com.codegym.repository;

import com.codegym.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void addStudent(Student student);
    Student findById(int id);
}
