package com.example.createblogapplication.controller;

import com.example.createblogapplication.model.Blog;
import com.example.createblogapplication.model.Category;
import com.example.createblogapplication.service.IBlogService;
import com.example.createblogapplication.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public String showDisplay(Model model,@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "") String searchName) {
        Pageable pageable = PageRequest.of(page,2, Sort.by("date").ascending());
        Page<Blog> blogPage = blogService.findAll(pageable,searchName);
        model.addAttribute("searchName",searchName);
        model.addAttribute("blogPage",blogPage);
        return "/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        Blog blog = blogService.findById(id);
        blogService.delete(blog);
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:/blog/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog",blog);
        model.addAttribute("categoryList", categoryService.findALl());
        return "create";
    }

    @PostMapping("/create")
    private String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blog.setDate(Date.valueOf(LocalDate.now()));
        blogService.add(blog);
        redirectAttributes.addFlashAttribute("msg","Bài viết đã được đăng lúc "+Date.valueOf(LocalDate.now()));
        return "redirect:/blog/list";
    }
    @RequestMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id,Model model){
        Blog blog = blogService.findById(id);
        List<Category> categoryList = categoryService.findALl();
        model.addAttribute("blog",blog);
        model.addAttribute("categoryList",categoryList);
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.edit(blog);
        redirectAttributes.addFlashAttribute("msg","Chỉnh sửa thành công");
        return "redirect:/blog/list";
    }
    @RequestMapping("/detail/{id}")
    public String showDetail(@PathVariable int id,Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "detail";
    }

}