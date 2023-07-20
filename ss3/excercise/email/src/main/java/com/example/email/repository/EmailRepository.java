package com.example.email.repository;

import com.example.email.model.Email;
import oracle.jrockit.jfr.openmbean.ProducerDescriptorType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmailRepository implements IEmailRepository{
    private static List<Email> emailList = new ArrayList<>();
    static {
        emailList.add(new Email(0,"english",5,true,"tiếng anh"));
        emailList.add(new Email(1,"chinese",10,false,"tiếng trung"));
        emailList.add(new Email(2,"france",15,true,"tiếng pháp"));
    }


    @Override
    public List<Email> showAll() {
        return emailList;
    }

    @Override
    public Email findById(int id) {
        for (Email email:emailList) {
            if (email.getId()==id){
                return email;
            }
        }
        return null;
    }

    @Override
    public void editMail(int id, Email email) {
        emailList.set(id,email);
    }


}
