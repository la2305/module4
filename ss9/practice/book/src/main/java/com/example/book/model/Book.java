package com.example.book.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;
    @Column(columnDefinition = "TEXT")
    private String image;
    private String description;
    @OneToMany(mappedBy = "book")
    private Set<BookCode> bookCodeSet;

    public Book() {
    }

    public Book(String name, int quantity, String image, String description, Set<BookCode> bookCodeSet) {
        this.name = name;
        this.quantity = quantity;
        this.image = image;
        this.description = description;
        this.bookCodeSet = bookCodeSet;
    }

    public Book(int id, String name, int quantity, String image, String description, Set<BookCode> bookCodeSet) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.image = image;
        this.description = description;
        this.bookCodeSet = bookCodeSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<BookCode> getBookCodeSet() {
        return bookCodeSet;
    }

    public void setBookCodeSet(Set<BookCode> bookCodeSet) {
        this.bookCodeSet = bookCodeSet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}