package com.vanessa.BookClub.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanessa.BookClub.Models.Book;
import com.vanessa.BookClub.Repos.BookRepo;

@Service
public class BookService {
	@Autowired
	private final BookRepo bookRepo;
  
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepo.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepo.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        return optionalBook.isPresent() ? optionalBook.get() : null;
    }
//  Update Method
	public Book updateBook(Book book) {
		Book updateBook = bookRepo.save(book);
		return updateBook;
	}
//	Delete Method
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
}
