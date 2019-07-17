package com.bookmanagement.spring.service;

import java.util.List;

import com.bookmanagement.spring.model.Book;

public interface BookService {
	public void addBook(Book book);

	public void updateBook(Book book);

	public List<Book> listBooks();

	public Book getBookById(int bookId);

	public void removeBook(int id);
}
