package com.example.book.service;

import com.example.book.model.BookCode;
import com.example.book.repository.IBookCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCodeService {
    @Autowired
    IBookCodeRepository bookCodeRepository;
    @Override
    public void add(BookCode bookCode) {
        bookCodeRepository.save(bookCode);
    }

    @Override
    public void delete(BookCode bookCode) {
        bookCodeRepository.delete(bookCode);
    }

    @Override
    public BookCode findById(int id) {
        return bookCodeRepository.findById(id).orElse(null);
    }

}
