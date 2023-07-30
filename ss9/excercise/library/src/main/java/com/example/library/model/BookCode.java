package com.example.library.model;

import javax.persistence.*;

@Entity
public class BookCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int code;
    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;

    public BookCode() {
    }

    public BookCode(int code, Book book) {
        this.code = code;
        this.book = book;
    }

    public BookCode(int id, int code, Book book) {
        this.id = id;
        this.code = code;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
