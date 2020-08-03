package com.springboot.libraryproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.libraryproject.entity.User;



public interface UserRepo extends JpaRepository<User, Integer> {

}
