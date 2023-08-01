package com.example.createblogapplication.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @GetMapping("/list")
    public String showDisplay(Model model, @RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "") String searchName){
        Pageable pageable = PageRequest.of(page,2, Sort.by("name").ascending());
        Page<Category> categoryPage = categoryService.findAll(pageable,searchName);
        model.addAttribute("categoryPage",categoryPage);
        return "/category/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        Category category = new Category();
        model.addAttribute("category",category);
        return "/category/create";
    }
    @PostMapping("/create")
    public String create(Category category,RedirectAttributes redirectAttributes){
        categoryService.add(category);
        redirectAttributes.addFlashAttribute("msg","Thêm mới thành công");
        return "redirect:/category/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,RedirectAttributes redirectAttributes){
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("msg","Xóa thành công");
        return "redirect:/category/list";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id,Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "/category/edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Category category,RedirectAttributes redirectAttributes){
        categoryService.edit(category);
        redirectAttributes.addFlashAttribute("msg","chỉnh sửa thành công");
        return "redirect:/category/list";
    }
    @GetMapping("/showBlog/{id}")
    public String showBlog(@PathVariable int id,Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "/category/info";
    }
}
