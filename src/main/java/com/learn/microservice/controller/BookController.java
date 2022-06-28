package com.learn.microservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.learn.microservice.model.Book;
import com.learn.microservice.service.BookExpo;
import com.learn.microservice.service.BookService;

//@RestController
public class BookController implements BookExpo {

	//@Autowired
    //private RestTemplate restTemplate;

    //String serverUrl = "http://bookclient/getbooks";
	
	@Autowired
	BookService bookService;
	
	@Override
	@RequestMapping("/getbooks")
	public String getAll() {
		// create a new Gson instance
		 Gson gson = new Gson();
		 // convert your list to json
		 String json = gson.toJson(bookService.getAll());
		return json;
	}
}
