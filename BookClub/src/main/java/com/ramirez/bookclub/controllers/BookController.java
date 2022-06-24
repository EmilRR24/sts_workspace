package com.ramirez.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ramirez.bookclub.models.Book;
import com.ramirez.bookclub.services.BookService;
import com.ramirez.bookclub.services.UserService;

@Controller
public class BookController {
	//IMPORT SERVICES
	@Autowired
	private BookService bookService;
	
	@Autowired 
	private UserService userService;
	
	// ----- READ ----- //
	@GetMapping("/books")
	public String book(
			HttpSession session,
			Model model,
			@ModelAttribute("bookObj") Book emptyBook
			) {
		//GRAB ALL BOOKS FROM DB
		List<Book> allBooks = bookService.allBooks();
		
		//PASS THE BOOKS TO JSP
		model.addAttribute("books", allBooks);
		//Session
		String userName = (String) session.getAttribute("name");
		model.addAttribute("name", userName);
		
		return "dashboard.jsp";
	}
	@GetMapping("/books/{id}")
	public String getBook(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session
			) {
		// GRAB ONE BOOK FROM DB
		Book oneBook = bookService.findBook(id);
		// PASS THE BOOK TO JSP
		model.addAttribute("book", oneBook);
		
		return "showBook.jsp";
	}
	// ----- /READ ----- //
	
	// ------ CREATE -------- //
	@GetMapping("/new")
	public String index(
			@ModelAttribute("bookObj") Book emptyBook
			) {
		return "book.jsp";
	}
	
	@PostMapping("/book/new")
	public String createBook(
			@Valid @ModelAttribute("bookObj") Book completedBook,
			BindingResult results,
			Model model
			) {
		//VALIDATIONS FAILED
		if(results.hasErrors()) {
			//GRAB ALL ERRORS 
			List<Book> allBooks = bookService.allBooks();
			
			//PASS THE ERRORS TO JSP
			model.addAttribute("books", allBooks);
			
			return "dashboard.jsp";
		}
		//VALIDATIONS PASSED
		bookService.createBook(completedBook);
		return "redirect:/books";	
	}
	
	// ------ /CREATE -------- //
	
	// ------ UPDATE -------- //
	@GetMapping("/edit/{id}")
	public String edit(
			@PathVariable("id") Long id,
			Model model
			){
		// Find one object from DB
		Book editBook = bookService.findBook(id);
		// Pass the travel object to jsp
		model.addAttribute("bookObj", editBook);
		
		return "edit.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String update(
			@Valid @ModelAttribute("bookObj") Book updatedBook,
			BindingResult results
			) {
			// VALIDATIONS HAVE FAILED
			if(results.hasErrors()) {
				return "edit.jsp";
			}
			// VALIDATIONS HAVE PASSED
			bookService.updateBook(updatedBook);
			return "redirect:/books";
	}
	// ------- /UPDATE ------- //
	
	// ------- DELETE ------- //
	@GetMapping("/delete/{id}")
	public String delete(
			@PathVariable("id") Long id
			) {
			bookService.deleteBook(id);
			return "redirect:/books";
	}
	// ------- /DELETE ------- //
	
}
