package com.example.validateinforuser.controller;

import com.example.validateinforuser.model.Blog;
import com.example.validateinforuser.service.BlogService;
import com.example.validateinforuser.service.IBlogService;
import com.example.validateinforuser.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;
    @GetMapping("/list")
    public String showList(Model model){
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList",blogList);
        return "/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog",blog);
        model.addAttribute("categoryList",categoryService.findAll());
        return "create";
    }

    @PostMapping("/create")
    private String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blog.setDate(Date.valueOf(LocalDate.now()));
        blogService.addBlog(blog);
        redirectAttributes.addFlashAttribute("msg","Bài viết đã được đăng lúc "+Date.valueOf(LocalDate.now()));
        return "redirect:/blog/list";
    }
}
