package com.codegym.service;

import com.codegym.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void addStudent(Student student);
    Student findById(int id);
}
