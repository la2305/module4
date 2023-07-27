package com.example.regist.service;

import com.example.regist.model.User;
import com.example.regist.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    public boolean addUser(User user) {
        if (user != null) {
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }
}
