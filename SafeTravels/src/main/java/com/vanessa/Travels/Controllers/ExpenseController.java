package com.vanessa.Travels.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vanessa.Travels.Services.ExpenseService;
import com.vanessa.Travels.models.Expense;

@Controller
public class ExpenseController {
	@Autowired
	private ExpenseService expenseService;

//	Home Page
	@RequestMapping("/home")
	public String home(@ModelAttribute("expense") Expense expese, Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}

//	Create Expense
	@PostMapping("/home")
	public String create(@Valid @ModelAttribute("expense") Expense expense ,BindingResult result,  Model model) {
//			
		if (result.hasErrors()) {
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/home";
		}
	}
	
//	View One
	
	@RequestMapping("/view/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpenses(id);
		model.addAttribute("expense", expense);
		return "view.jsp";
	}
	
	
	
//	Edit
	
	 @RequestMapping("/edit/{id}")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Expense expense = expenseService.findExpenses(id);
	        model.addAttribute("expense", expense);
	        return "edit.jsp";
	    }
	    
	    @RequestMapping(value="/editService/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
	        if (result.hasErrors()) {
	        	System.out.println(result);
	            return "edit.jsp";
	        } else {
	        	expenseService.updateExpense(expense);
	            return "redirect:/home";
	        }
	    }
	    
//	    DELETE
	    
	    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	    public String destroy(@PathVariable("id") Long id) {
	        expenseService.deleteExpense(id);
	        return "redirect:/home";
	    }

}
