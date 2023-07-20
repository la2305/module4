package com.codegym;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class ControllerChangeMoney {
    @GetMapping("/change")
    public String show(){
        return "list";
    }
    @PostMapping("/change")
    public String changeMoney(@RequestParam double money, @RequestParam double rate, Model model){
        double moneyAfterChange = money*rate;
        model.addAttribute("moneyAfterChange",moneyAfterChange);
        return "list";
    }

}
