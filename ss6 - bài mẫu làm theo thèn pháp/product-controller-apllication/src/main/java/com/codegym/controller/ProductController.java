package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.beans.Customizer;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService ;
    @GetMapping("")
    public String home(Model model){
        List<Product> productList =productService.findAll();
        model.addAttribute("productList",productList);
        return "/home";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }
    @PostMapping("/create")
    public String create(Product product, RedirectAttributes redirectAttributes ){
        product.setId((int) (Math.random()*10000));
        productService.addProduct(product);
        redirectAttributes.addFlashAttribute("msg","Add successful");
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable int id,Model model){
        model.addAttribute("product",productService.selectById(id));
        return "/edit";
    }
    @PostMapping("/edit")
    public String edit(Product product, RedirectAttributes redirectAttributes){
        productService.editProduct(product.getId(),product);
        redirectAttributes.addFlashAttribute("msg","Edit successful");
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String showDelete(@PathVariable int id,RedirectAttributes redirectAttributes){
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("msg","delete successful");
        return "redirect:/product";
    }
    @GetMapping("/{id}/detail")
    public String detail(@PathVariable int id, Model model){
        model.addAttribute("product",productService.selectById(id));
        return "/detail";
    }

    @GetMapping("/search")
    public String search(@RequestParam  String name, Model model){
        List<Product> productList = productService.search(name);
        model.addAttribute("productList",productList);
        return "/home";
    }
}
