package com.example.book.repository;
import com.example.book.model.BookCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookCodeRepository extends JpaRepository<BookCode,Integer> {
}
