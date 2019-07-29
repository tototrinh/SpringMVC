package com.bookmanagement.spring.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.*;

@Entity
@Table(name = "book_tbl")
public class Book {

	public Book() {
	}

	public Book(String name, Category category, Set<Author> authors) {
		_bookName = name;
		_authors = authors;
		_category = category;
	}

	public Book(String name, Category category, Author... authors) {
		_bookName = name;
		_authors = Stream.of(authors).collect(Collectors.toSet());
		_authors.forEach(x -> x.getBooks().add(this));
		_category = category;
	}

	public Book(int id, String name, Category category, Set<Author> authors) {
		_bookId = id;
		_bookName = name;
		_category = category;
		_authors = authors;
	}

	public int getBookId() {
		return _bookId;
	}

	public void setBookId(int bookId) {
		_bookId = bookId;
	}

	public String getBookName() {
		return _bookName;
	}

	public void setBookName(String bookName) {
		_bookName = bookName;
	}

	public Category getCategory() {
		return _category;
	}

	public void setCategory(Category category) {
		_category = category;
	}

	public Set<Author> getAuthors() {
		return _authors;
	}

	public void setAuthors(Set<Author> authors) {
		_authors = authors;
	}

	public String getAuthorNames() {
		String names = "";
		for (Author author : this._authors) {
			names += author.getAuthName() + ", ";
		}
		return names.substring(0, names.length() - 2);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int _bookId;

	@Column(name = "book_name")
	private String _bookName;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "author_book_tbl", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> _authors;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category _category;

}
