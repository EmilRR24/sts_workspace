package com.ramirez.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramirez.bookclub.models.Book;
import com.ramirez.bookclub.repositories.BookRepository;

@Service
public class BookService {
	// DEPENDENCY INJECT
	@Autowired
	BookRepository bookRepo;
	
	//RETURNS ALL BOOKS
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	//RETRIEVES A BOOK
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	//CREATES A BOOK
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	//UPDATES A BOOK
	public Book updateBook(Book updatedBook) {
		return bookRepo.save(updatedBook);
	}
	//DELETES A BOOK
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
	
}
