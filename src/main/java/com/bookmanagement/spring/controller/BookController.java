package com.bookmanagement.spring.controller;

import com.bookmanagement.spring.model.Book;
import com.bookmanagement.spring.model.Category;
import com.bookmanagement.spring.model.Author;
import com.bookmanagement.spring.service.BookService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

	@Autowired(required = true)
	@Qualifier(value = "bookService")
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String listBooks(Model model) {
		model.addAttribute("listBooks", this.bookService.listBooks());
		return "books";
	}

	@RequestMapping(value = "/book-new", method = RequestMethod.GET)
	public String sendToNewForm() {
		return "book";
	}

	@RequestMapping(value = "/book-edit", method = RequestMethod.GET)
	public String sendToEditForm(@RequestParam("id") int id, Model model) {
		model.addAttribute("book", this.bookService.getBookById(id));
		return "book";
	}

	@PostMapping(value = "/book-save")
	public String addBook(@RequestParam(value = "id", required = false, defaultValue = "-1") int id,
			@RequestParam("name") String name, @RequestParam("category") String categoryName,
			@RequestParam("author") String authorList) {

		List<String> authorNames = new ArrayList<String>(Arrays.asList(authorList.split(", ")));

		Set<Author> authors = new HashSet<>();

		for (String n : authorNames) {
			Author author = new Author(n);
			authors.add(author);
		}
		Category category = new Category(categoryName);
		if (id < 0) {
			Book book = new Book(name, category, authors);
			this.bookService.addBook(book);
		} else {
			Book book = new Book(new Integer(id), name, category, authors);
			this.bookService.updateBook(book);
		}
		return "redirect:/books";
	}

	@RequestMapping("/book-remove/{id}")
	public String removeBook(@PathVariable("id") int id) {

		this.bookService.removeBook(id);
		return "redirect:/books";
	}

	private BookService bookService;
}
