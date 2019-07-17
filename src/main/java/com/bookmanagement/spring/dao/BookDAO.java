package com.bookmanagement.spring.dao;

import java.util.List;

import com.bookmanagement.spring.model.Book;

public interface BookDAO {

	public void addBook(Book book);

	public void updateBook(Book book);

	public List<Book> listBooks();

	public Book getBookById(int bookId);

	public void removeBook(int id);

}
