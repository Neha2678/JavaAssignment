package com.example.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.model.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
