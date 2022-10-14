package com.vanessa.Travels.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vanessa.Travels.Repos.ExpenseRepo;
import com.vanessa.Travels.models.Expense;


@Service
public class ExpenseService {
	@Autowired
	private final ExpenseRepo expenseRepo;
//	Adding Dependency
	public ExpenseService(ExpenseRepo expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
//	Get All
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
//	Create One
	public Expense createExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
//	Read One
	public Expense findExpenses(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		else {
			return null;
		}
	}
	
//	Update
	
	public Expense updateExpense(Expense expense) {
		Expense updateexpense = expenseRepo.save(expense);
		return updateexpense;
	}
	
//	Delete
	
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
	
}
