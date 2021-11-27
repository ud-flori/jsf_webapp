package com.jsfspring.curddemo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsfspring.curddemo.entity.BookDTO;

@Repository
public interface BooksRepo extends JpaRepository<BookDTO, Long> {
}