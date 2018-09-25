package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.BookRepository;
@Controller
public class BookController {

	/**
	 * Spring will autowire the bookrepository and will give us an instance
	 */
	private BookRepository bookrepository;
	public BookController(BookRepository bookrepository) {
		this.bookrepository = bookrepository;
	}
	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", bookrepository.findAll());
		return "books";
	}
}
