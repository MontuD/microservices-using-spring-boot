package com.example.bookcatalogservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookcatalogservice.entity.Book;
import com.example.bookcatalogservice.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public Optional<Book> saveBookToDatabase(Book book){		
		return Optional.of(this.bookRepository.save(book));
	}
	
	public Optional<List<Book>> saveBookSToDatabase(List<Book> books){		
		return Optional.of(this.bookRepository.saveAll(books));
	}
	
	
	public Optional<List<Book>> getBookByBookName(String bookName){
		List<Book> books = this.bookRepository.getBookByBookName(bookName);
		return Optional.ofNullable(books);
	}
	
	public Optional<List<Book>> getBookByAuthor(String author){
		List<Book> books = this.bookRepository.getBookByAuthor(author);
		return Optional.ofNullable(books);
	}

	public Optional<List<Book>> getAllBooks() {
		return Optional.ofNullable(this.bookRepository.findAll());
	}
	
	public Optional<Book> addBook(Book book) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(this.bookRepository.save(book));
	}

	public Optional<List<Book>> addBooks(List<Book> book) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(this.bookRepository.saveAll(book));
	}
	

}
