package com.example.library.service;

import com.example.library.model.Book;

import com.example.library.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findByIdBook(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void edit(Book book) {
        bookRepository.save(book);
    }
}
