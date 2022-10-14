package com.vanessa.Books.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vanessa.Books.Models.BookModels;
import com.vanessa.Books.Repos.BookRepo;

@Service
public class BookService {
	@Autowired
	private final BookRepo bookRepo;
  
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
    // returns all the books
    public List<BookModels> allBooks() {
        return bookRepo.findAll();
    }
    // creates a book
    public BookModels createBook(BookModels b) {
        return bookRepo.save(b);
    }
    // retrieves a book
    public BookModels findBook(Long id) {
        Optional<BookModels> optionalBook = bookRepo.findById(id);
        return optionalBook.isPresent() ? optionalBook.get() : null;
//        if(optionalBook.isPresent()) {
//            return optionalBook.get();
//        } else {
//            return null;
//        }
    }
    
//    Update Method
	public BookModels updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		// TODO Auto-generated method stub
		return null;
	}
//	Delete Method
	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		
	}

}
