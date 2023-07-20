package com.example.email.service;

import com.example.email.model.Email;

import java.util.List;

public interface IEmailService {
    List<Email> showAll();
    Email findById(int id);
    void editMail(int id,Email email);
}
