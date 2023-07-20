package com.example.email.model;

import java.util.Objects;

public class Email {
    private int id;
    private String language;
    private int size;
    boolean filter;
    private String signature;

    public Email() {
    }

    public Email(int id, String language, int size, boolean filter, String signature) {
        this.id = id;
        this.language = language;
        this.size = size;
        this.filter = filter;
        this.signature = signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return id == email.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", size=" + size +
                ", filter=" + filter +
                ", signature='" + signature + '\'' +
                '}';
    }
}
