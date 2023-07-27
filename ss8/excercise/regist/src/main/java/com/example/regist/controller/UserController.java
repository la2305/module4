package com.example.regist.controller;

import com.example.regist.dto.UserDto;
import com.example.regist.model.User;
import com.example.regist.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    IUserService userService;
    @GetMapping("/register")
    public String showFormRegister(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto",userDto);
        return "/register";
    }
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute UserDto userDto,
                           BindingResult bindingResult,
                           Model model,
                           RedirectAttributes redirectAttributes) {
        User user = new User();
        new UserDto().validate(userDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("userDto",userDto);
            return "/register";
        }
        BeanUtils.copyProperties(userDto,user);
        boolean check = userService.addUser(user);
        if (check){
            redirectAttributes.addFlashAttribute("msg","Thêm mới thành công");
            return "/result";
        }else {
            redirectAttributes.addFlashAttribute("msg","Thêm mới không thành công");
            return "/register";
        }
    }
}
