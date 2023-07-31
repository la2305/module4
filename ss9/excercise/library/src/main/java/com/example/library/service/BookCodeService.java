package com.example.library.service;

import com.example.library.model.BookCode;
import com.example.library.repository.IBookCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookCodeService implements IBookCodeService{
    @Autowired
    private IBookCodeRepository bookCodeRepository;

    @Override
    public void add(BookCode bookCode) {
        bookCodeRepository.save(bookCode);
    }

    @Override
    public void delete(int code) {
        bookCodeRepository.deleteBookCodeByCode(code);
    }

    @Override
    public BookCode findByCode(int code) {
        return bookCodeRepository.findBookCodeByCode(code);
    }
}
