package com.example.sandwichcondiments;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CondimentController {
    @GetMapping("/")
    public String showList() {
        return "/condiment";
    }

    @PostMapping("/result")
    public ModelAndView save(@RequestParam(value = "condiment", required = false) String[] condiment) {
        ModelAndView modelAndView = new ModelAndView("/result");
        if (condiment == null || condiment.length == 0) {
            modelAndView.addObject("msg","please choose");
        }else {
            modelAndView.addObject("condiment",condiment);
        }
        return modelAndView;
    }

}
