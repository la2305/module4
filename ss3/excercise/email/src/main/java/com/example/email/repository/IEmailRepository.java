package com.example.email.repository;

import com.example.email.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<Email> showAll();
    Email findById(int id);
    void editMail(int id, Email email);

}
