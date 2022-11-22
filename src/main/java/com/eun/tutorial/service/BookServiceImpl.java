package com.eun.tutorial.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eun.tutorial.dto.Book;
import com.eun.tutorial.exception.DuplicateBookException;
import com.eun.tutorial.util.StringUtils;

@Service
public class BookServiceImpl implements BookService {

	@Override
	public Collection<Book> getBooks() {
		List<Book> bookList = new ArrayList<Book>();
		Book book1 = Book.builder().isbn("isbn1").name("name1").author("author1").build();
		Book book2 = Book.builder().isbn("isbn2").name("name2").author("author2").build();
		bookList.add(book1);
		bookList.add(book2);
		return bookList;
	}

	@Override
	public Book addBook(Book book) {
		if (StringUtils.isBlank(book.getIsbn())) {
			throw new DuplicateBookException(book);
		}
		return null;
	}

}
