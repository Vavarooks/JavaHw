package com.vanessa.BookClub.Controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vanessa.BookClub.Models.Book;
import com.vanessa.BookClub.Models.LoginUser;
import com.vanessa.BookClub.Models.User;
import com.vanessa.BookClub.Services.BookService;
import com.vanessa.BookClub.Services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;

//	Login / Register Page
	@GetMapping("/")
	public String index(Model model) {
//		List<User> users = userService.allUsers();
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}

// View Users and Books
	@RequestMapping("/view/user")
	public String viewUser(HttpSession session, Model model) {
		Long id = (Long) session.getAttribute("id");
		model.addAttribute("user", userService.findUser(id));
		List<Book> books = bookService.allBooks();
		model.addAttribute("book", books);
		return "view.jsp";
	}

//	View One Book
	@RequestMapping("/book/{id}")
	public String oneBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userid = (Long) session.getAttribute("userid");
		model.addAttribute("user", userService.findUser(userid));
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "onebook.jsp";
	}

//	Add Book
	@GetMapping("/create/book")
	public String newBook(@ModelAttribute("newBook") Book book, Model model) {
		return "create.jsp";
	}

	@PostMapping("/create/book")
	public String createBook(@Valid @ModelAttribute("newBook") Book book, 
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			Book books = new Book();
			model.addAttribute("book", books);
			return "create.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/view/user";
		}
	}
	
//	Edit Book
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
	return "edit.jsp";
	}
	
	@RequestMapping(value="/changes/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("book")Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			bookService.updateBook(book);
			return "redirect:/book/{id}";
		}
	}
//	Delete Book
	@PostMapping(value="/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/view/user";
	}
	
//	Registration
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {
		// to do some extra validations and create a new user!
		User user = userService.register(newUser, result);

		if (result.hasErrors()) {
			// Be sure to send in the empty LoginUser before
			// re-rendering the page.
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}

		// No errors!
		session.setAttribute("userid", user.getId());
		// in other words, log them in.

		return "redirect:/view/user";
	}

//	     Log in!
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {
		System.out.println("inside login method------------------");
		// Add once service is implemented:
		User user = userService.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			System.out.println("re render the index --------------------");
			return "index.jsp";
		} else {
			// No errors
			session.setAttribute("userid", user.getId());
			// in other words, log them in.
			return "redirect:/view/user";
		}

	}

//	    Log out
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
