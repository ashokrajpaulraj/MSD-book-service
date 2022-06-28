package com.learn.microservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.microservice.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
