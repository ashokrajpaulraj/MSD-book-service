package com.learn.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.microservice.model.Book;
import com.learn.microservice.repo.BookRepo;

@Service
public class BookService {

	@Autowired
	BookRepo bookRepo;
	
	public void addBook(Book book){
		bookRepo.save(book);
	}

	public List<Book> getAll(){
		return bookRepo.findAll();
	}
	
	public void deleteBook(int id) {
		bookRepo.delete( Book.builder().id(id).build() );
	}
	
}
