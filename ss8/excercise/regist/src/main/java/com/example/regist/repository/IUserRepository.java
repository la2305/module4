package com.example.regist.repository;

import com.example.regist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer>{
}
