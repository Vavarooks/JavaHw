package com.vanessa.Books.Repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vanessa.Books.Models.BookModels;

@Repository
public interface BookRepo extends CrudRepository<BookModels, Long> {
	List<BookModels> findAll();
}
