package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping("/student/list")
    public String showList(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList",studentList);
        return "list";
    }
    @GetMapping("/student/create")
    public String showCreateFomr(){
        return "create";
    }
    @PostMapping("/student/create")
    public String save(@RequestParam int id, @RequestParam String name,Model model){
        Student student = new Student(id,name);
        studentService.addStudent(student);
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList",studentList);
        return "list";
    }
}
