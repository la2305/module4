package com.example.email.controller;

import com.example.email.model.Email;
import com.example.email.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmailController {
    @Autowired
    private IEmailService emailService;

    @GetMapping("/email/list")
    public String showList(Model model) {
        List<Email> emailList = emailService.showAll();
        model.addAttribute("emailList",emailList);
        return "/list";
    }

    @GetMapping("/email/edit")
    public String showEdit( int id, Model model) {
        Email email = emailService.findById(id);
        model.addAttribute("id", id);
        model.addAttribute("email", email);
        return "/edit";
    }
    @PostMapping("/email/edit")
    public String edit(@ModelAttribute Email email) {
        emailService.editMail(email.getId(),email);
        return "redirect:/email/list";
    }


    @ModelAttribute("ngonNgu")
    public String[] getLanguages() {
        return new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
    }

    @ModelAttribute("pageSize")
    public int[] pageSize() {
        return new int[]{5,10,15,25,50,100};
    }


}
