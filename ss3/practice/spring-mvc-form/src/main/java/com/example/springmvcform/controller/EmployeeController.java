package com.example.springmvcform.controller;

import com.example.springmvcform.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
    @Autowired
    private

    @RequestMapping(value = "showForm", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @RequestMapping(value = "addEmployee", method = RequestMethod.POST)
    public String submit(@ModelAttribute("employee") Employee employee, ModelMap model) {
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        return "employee/info";
    }
}
