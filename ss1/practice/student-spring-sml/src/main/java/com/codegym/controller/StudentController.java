package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    @Qualifier("studentService")
    private IStudentService studentService;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView showList(Model model){
        List<Student> studentList = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("studentList",studentList);
        return modelAndView;
    }
    @GetMapping("/create")
    public String showCreateFomr(){
        return "create";
    }
    @PostMapping("/create")
    public String save(@RequestParam int id, @RequestParam String name, RedirectAttributes redirectAttributes){
        Student student = new Student(id,name);
        studentService.addStudent(student);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/student/list";
    }
    @GetMapping("/detail")
    public String detail1 (@RequestParam int id, Model model){
        Student student =studentService.findById(id);
        model.addAttribute("student",student);
        return "detail";
    }
}
