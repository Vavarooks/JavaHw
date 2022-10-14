package com.vanessa.Books.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vanessa.Books.Models.BookModels;
import com.vanessa.Books.Services.BookService;

@RestController
public class BookView {

	private final BookService bookService;

	public BookView(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}

	@RequestMapping("/api/books")
	public List<BookModels> index() {

		return bookService.allBooks();
	}

	@RequestMapping(value = "/api/books", method = RequestMethod.POST)
	public BookModels create(@RequestParam(value = "title") String title,
			@RequestParam(value = "description") String desc, @RequestParam(value = "language") String lang,
			@RequestParam(value = "pages") Integer numOfPages) {
		BookModels book = new BookModels(title, desc, lang, numOfPages);
		return bookService.createBook(book);
	}

	@RequestMapping("/api/books/{id}")
	public BookModels show(@PathVariable("id") Long id) {
		BookModels book = bookService.findBook(id);
		return book;
	}
//	Update
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	    public BookModels update(
	    		@PathVariable("id") Long id, 
	    		@RequestParam(value="title") String title, 
	    		@RequestParam(value="description") String desc, 
	    		@RequestParam(value="language") String lang,
	    		@RequestParam(value="pages") Integer numOfPages) {
	        BookModels book = bookService.updateBook(id, title, desc, lang, numOfPages);
	        return book;
	    }
//	    Delete
	    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
	    public void destroy(@PathVariable("id") Long id) {
	        bookService.deleteBook(id);
	    }

}
