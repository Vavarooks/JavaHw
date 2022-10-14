package com.vanessa.Travels.Repos;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vanessa.Travels.models.Expense;

@Repository
public interface ExpenseRepo extends CrudRepository<Expense, Long> {
	List<Expense> findAll();
}
