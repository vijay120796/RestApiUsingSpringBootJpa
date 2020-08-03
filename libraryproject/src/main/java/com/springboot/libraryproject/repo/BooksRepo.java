package com.springboot.libraryproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.libraryproject.entity.Books;



public interface BooksRepo extends JpaRepository<Books, Integer>{

}
