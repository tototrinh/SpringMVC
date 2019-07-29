package com.bookmanagement.spring.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.*;

@Entity()
@Table(name = "category_tbl")
public class Category {

	public Category() {
	}

	public Category(String name) {
		_categName = name;
	}

	public Category(int id, String name) {
		_categId = id;
		_categName = name;
	}

	public Category(String name, Book... books) {
		_categName = name;
		_books = Stream.of(books).collect(Collectors.toSet());
		_books.forEach(x -> x.setCategory(this));
	}

	public int getCategId() {
		return _categId;
	}

	public void setCategId(int categId) {
		_categId = categId;
	}

	public String getCategName() {
		return _categName;
	}

	public void setCategName(String categName) {
		_categName = categName;
	}

	public Set<Book> getBooks() {
		return _books;
	}

	public void setBooks(Set<Book> books) {
		_books = books;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int _categId;

	@Column(name = "category_name")
	private String _categName;

	@OneToMany(mappedBy = "_category", cascade = CascadeType.ALL)
	private Set<Book> _books;

}
