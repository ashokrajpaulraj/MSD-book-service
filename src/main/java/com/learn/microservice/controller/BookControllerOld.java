package com.learn.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.learn.microservice.model.Book;
import com.learn.microservice.service.BookService;

@RestController
public class BookControllerOld {

	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public String home() {
		return "Book service home page";
	}
	
	@GetMapping("/addbook") //http:localhost:8081/addbook
	public String addBook(int id, String name, String author) {
		System.out.println("book controller add called");
		bookService.addBook( Book.builder().id(id).name(name).author(author).build() );
		return "book added"; 
	}
	
	@GetMapping("/getbooks")//http:localhost:8081/getbooks
	public String getAll() {
		// create a new Gson instance
		 Gson gson = new Gson();
		 // convert your list to json
		 String json = gson.toJson(bookService.getAll());
		return json;
	}
	
	@GetMapping("/deletebook")
	public String deleteBook(int id) {
		bookService.deleteBook(id);
		return "Book deleted";
	}
	
}
