package com.codegym.repository;

import com.codegym.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepository implements IStudentRepository{
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"Chánh1",1,"java"));
        studentList.add(new Student(2,"Chánh2",2,"alo"));
        studentList.add(new Student(3,"Chánh3",1,"php"));
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public Student findById(int id) {
        for (Student s:studentList) {
            if (s.getId()==id){
                return s;
            }
        }
        return null;
    }
}
