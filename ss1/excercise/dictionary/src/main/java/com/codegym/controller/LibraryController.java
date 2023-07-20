package com.codegym.controller;

import com.codegym.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LibraryController {
    @Autowired
    private  ILibraryService libraryService;
    @GetMapping("/translate")
    public String showTranslateForm(){
        return "/list";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam String word, Model model){
        String translate = libraryService.translate(word.trim());
        if (translate==null){
            translate = "Can not find";
        }
        model.addAttribute("translate",translate);
        return "list";
    }
}
