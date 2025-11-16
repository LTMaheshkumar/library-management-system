package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
