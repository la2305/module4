package com.example.library.service;

import com.example.library.model.Book;


import java.util.List;

public interface IBookService {
    List<Book> findAll();
    void addBook(Book book);
    Book findByIdBook(int id);
    void edit(Book book);

}
