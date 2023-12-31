package com.codegym.service;

import com.codegym.repository.ILibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService implements ILibraryService{
    @Autowired
    private ILibraryRepository libraryRepository;
    @Override
    public String translate(String word) {
        return libraryRepository.translate(word);
    }
}
