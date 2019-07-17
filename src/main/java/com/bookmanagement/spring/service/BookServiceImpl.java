package com.bookmanagement.spring.service;

import com.bookmanagement.spring.dao.BookDAO;
import com.bookmanagement.spring.model.Book;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookService")
public class BookServiceImpl implements BookService {

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	@Transactional
	public void addBook(Book book) {
		this.bookDAO.addBook(book);

	}

	@Override
	@Transactional
	public void updateBook(Book book) {
		this.bookDAO.updateBook(book);
	}

	@Override
	@Transactional
	public List<Book> listBooks() {
		return this.bookDAO.listBooks();
	}

	@Override
	@Transactional
	public Book getBookById(int bookId) {
		return this.bookDAO.getBookById(bookId);
	}

	@Override
	@Transactional
	public void removeBook(int id) {
		this.bookDAO.removeBook(id);
	}

	private BookDAO bookDAO;

}
