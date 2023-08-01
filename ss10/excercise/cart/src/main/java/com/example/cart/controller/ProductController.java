package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
    @GetMapping("/sub/{id}")
    public String subToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action){
        Optional<Product> productOptional =productService.findById(id);
        if (!productOptional.isPresent()){
            return "/error_404";
        }
        if (action.equals("show")){
            cart.subProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.subProduct(productOptional.get());
        return "redirect:/shop";
    }
    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable Long id, Model model){
        Product product = productService.findById(id).get();
        model.addAttribute("product",product);
        return "/detail";
    }
    @GetMapping("/pay")
    public String payCart(@ModelAttribute Cart cart, RedirectAttributes redirectAttributes){
        float totalPayment = cart.countTotalPayment();
        cart.clearCart();
        redirectAttributes.addFlashAttribute("totalPayment",totalPayment);
        redirectAttributes.addFlashAttribute("msg","Thanh toán thành công, tổng hóa đơn của bạn là: " +totalPayment+"VNĐ");
        return "redirect:/shopping-cart";
    }
}
