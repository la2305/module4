package com.example.email.service;

import com.example.email.model.Email;
import com.example.email.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmailService implements IEmailService{
    @Autowired
    private IEmailRepository emailRepository;
    @Override
    public List<Email> showAll() {
        return emailRepository.showAll();
    }

    @Override
    public Email findById(int id) {
        return emailRepository.findById(id);
    }

    @Override
    public void editMail(int id, Email email) {
        emailRepository.editMail(id,email);
    }


}
