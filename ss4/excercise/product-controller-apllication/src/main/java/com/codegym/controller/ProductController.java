package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.beans.Customizer;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService productService = new ProductService();
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
    public String create(Product product ){
        product.setId((int) (Math.random()*10000));
        productService.addProduct(product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable int id,Model model){
        model.addAttribute("product",productService.selectById(id));
        return "/edit";
    }
    @PostMapping("/edit")
    public String edit(Product product){
        productService.editProduct(product.getId(),product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String showDelete(@PathVariable int id){
        productService.deleteProduct(id);
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
