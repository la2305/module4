package com.codegym.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Repository
public class LibraryRepository implements ILibraryRepository{
    private static HashMap<String,String> library = new HashMap<>();
    static {
        library.put("apple","táo");
        library.put("orange","cam");
        library.put("banana","chuối");
        library.put("coconut","dừa");
    }
    @Override
    public String translate(String word) {
        return library.get(word);
    }
}
