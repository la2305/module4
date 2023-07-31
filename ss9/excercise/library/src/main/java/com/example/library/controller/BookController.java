package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.model.BookCode;
import com.example.library.service.IBookCodeService;
import com.example.library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Controller
public class BookController {
    @Autowired
    IBookService bookService;
    @Autowired
    IBookCodeService bookCodeService;

    @GetMapping("/list")
    public String showList(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "/list";
    }

    @GetMapping("/detail/{id}")
    public String showBorrow(@PathVariable int id, Model model) {
        Book book = bookService.findByIdBook(id);
        model.addAttribute("book", book);
        return "/detail";
    }

    @GetMapping("/borrow/{id}")
    public String borrow(@PathVariable int id, Model model) {
        Book book = bookService.findByIdBook(id);
        System.out.println(book);
        Random random = new Random();
        int randomNumber = random.nextInt(90000) + 10000;
        if (book.getQuantity() >= 1) {
            book.setQuantity(book.getQuantity() - 1);
            BookCode bookCode = new BookCode(randomNumber, book);
            bookCodeService.add(bookCode);
            model.addAttribute("randomNumber", randomNumber);
            return "/ok";
        } else {
            return "/not";
        }
    }

    @GetMapping("/pay/{id}")
    public String payShow(@PathVariable int id, Model model) {
        Book book = bookService.findByIdBook(id);
        model.addAttribute("book", book);
        return "/pay";
    }

    @PostMapping("/give")
    public String giveBook(@RequestParam int code,@RequestParam int id, Model model) {
        System.out.println(id);
        BookCode bookCode = bookCodeService.findByCode(code);
        if (bookCode != null) {
            bookCodeService.delete(code);
            Book book = bookCode.getBook();
            book.setQuantity(book.getQuantity() + 1);
            bookService.addBook(book);
            model.addAttribute("msg", "Trả sách thành công");
            model.addAttribute("bookList", bookService.findAll());
            return "/list";
        } else {
            Book book = bookService.findByIdBook(id);
            model.addAttribute("book",book);
            model.addAttribute("msg", "Mã trả sách của bạn sai rồi");
            return "/pay";
        }
    }
}
