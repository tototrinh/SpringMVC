package com.bookmanagement.spring.model;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "author_tbl")
public class Author {

	public Author() {
	}

	public Author(String name) {
		_authName = name;

	}

	public Author(int id, String name) {
		_authId = id;
		_authName = name;
	}

	public int getAuthId() {
		return _authId;
	}

	public void setAuthId(int authId) {
		_authId = authId;
	}

	public String getAuthName() {
		return _authName;
	}

	public void setAuthName(String authName) {
		_authName = authName;
	}

	public Set<Book> getBooks() {
		return _books;
	}

	public void setBooks(Set<Book> books) {
		_books = books;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_id")
	private int _authId;

	@Column(name = "author_name")
	private String _authName;

	@ManyToMany(mappedBy = "_authors")
	private Set<Book> _books = new HashSet<>();

}
