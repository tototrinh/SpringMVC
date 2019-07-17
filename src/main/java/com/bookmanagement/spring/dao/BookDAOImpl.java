package com.bookmanagement.spring.dao;

import com.bookmanagement.spring.model.Book;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.slf4j.*;

@Repository
public class BookDAOImpl implements BookDAO{
	
	public void setSessionFactory(SessionFactory sf){
		this._sessionFactory = sf;
	}
	
	@Override
	public void addBook(Book book) {
		Session session = this._sessionFactory.getCurrentSession();
		session.persist(book);
		_logger.info("Book saved successfully, Book Details="+ book);		
	}
	
	@Override
	public void updateBook(Book book) {
		Session session = this._sessionFactory.getCurrentSession();
		session.update(book);
		_logger.info("Book saved successfully, Book Details="+ book);	
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> listBooks(){
		Session session = this._sessionFactory.getCurrentSession();
		List<Book> books = session.createQuery("from Book").list();
		for(Book p : books){
			_logger.info("Book List::"+p);
		}
		return books;
	}
	@Override
	public Book getBookById(int bookId) {
		Session session = this._sessionFactory.getCurrentSession();		
		Book book = session.load(Book.class, new Integer(bookId));
		_logger.info("Book loaded successfully, Book details="+book);
		return book;
		
	}
	@Override
	public void removeBook(int id) {
		Session session = this._sessionFactory.getCurrentSession();
		Book book = session.load(Book.class, new Integer(id));
		if(null != book){
			session.delete(book);
		}
		_logger.info("Book deleted successfully, person details="+book);
	}
	
	private static final Logger _logger = (Logger) LoggerFactory.getLogger(BookDAOImpl.class);
	
	@Autowired
	private SessionFactory _sessionFactory;
	

}
