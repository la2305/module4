package com.example.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String showCalculator() {
        return "/calculator";
    }

    @PostMapping("/")
    public String calculator(@RequestParam(value = "first",required = false) Integer first, @RequestParam(value = "second",required = false) Integer second, @RequestParam("calculation") String calculation, Model model) {
        int result = 0;
        String mess =null;
        if (first==null || second==null){
            mess =" Please enter enough information";
        }else {
            switch (calculation) {
                case "+":
                    result = first + second;
                    break;
                case "-":
                    result = first - second;
                    break;
                case "*":
                    result = first * second;
                    break;
                case "/":
                    if (second==0){
                        mess ="please enter number second different 0 when you want to division";
                        break;
                    }else {
                        result = first /second;
                    }
                    break;
            }
        }
        model.addAttribute("result",result);
        model.addAttribute("mess",mess);
        return "/calculator";
    }
}
