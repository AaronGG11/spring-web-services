package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class booksControler {
	@GetMapping("/books")
	public List<book> getAllBooks(){
		return Arrays.asList(
				new book(1l,"Soy sola 5.7", "Pedro y Teo"));
	}
	
}
