package com.example.library.service;


import com.example.library.model.BookCode;

public interface IBookCodeService {
    void add(BookCode bookCode);
    void delete(int code);
    BookCode findByName(int code);
}
