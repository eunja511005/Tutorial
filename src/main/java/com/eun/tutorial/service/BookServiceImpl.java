package com.eun.tutorial.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eun.tutorial.dto.Book;

@Service
public class BookServiceImpl implements BookService {

	@Override
	public Collection<Book> getBooks() {
		List<Book> bookList = new ArrayList<Book>();
		Book book1 = Book.builder()
				.isbn("isbn1")
				.name("name1")
				.author("author1")
				.build();
		Book book2 = Book.builder()
				.isbn("isbn2")
				.name("name2")
				.author("author2")
				.build();
		bookList.add(book1);
		bookList.add(book2);
		return bookList;
	}

	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

}
