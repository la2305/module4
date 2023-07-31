package com.example.library.common;

import com.example.library.model.Book;
import com.example.library.model.BookCode;
import com.example.library.service.IBookCodeService;
import com.example.library.service.IBookService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    @Autowired
    IBookService bookService;
    @Autowired
    IBookCodeService bookCodeService;
    @After("execution(* com.example.library.controller.BookController.borrow(..))")
    public void borrowBook(JoinPoint joinPoint){
        Object[] ags = joinPoint.getArgs();
        Book book =bookService.findByIdBook((int) ags[0]);
        System.out.println("khách đã mượn 1 cuốn sách tên :" +book.getName());
    }
    @Before("execution(* com.example.library.controller.BookController.giveBook())")
    public void giveBook(JoinPoint joinPoint){
        Object[] ags =joinPoint.getArgs();
        BookCode bookCode = bookCodeService.findByCode((int) ags[0]);
        System.out.println("Khách đã trả 1 cuốn sách tên: "+bookCode.getBook().getName());
    }
}
