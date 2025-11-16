package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
