package com.vanessa.LoginReg.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vanessa.LoginReg.Models.LoginUser;
import com.vanessa.LoginReg.Models.User;
import com.vanessa.LoginReg.Services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

//	Login / Register Page
	@GetMapping("/")
	public String index(Model model) {
//		List<User> users = userService.allUsers();
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}

	@RequestMapping("/view/user")
	public String viewUser() {
		return "view.jsp";
	}

//	Registration
	@PostMapping("/register") 
	public String register(@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result, Model model, HttpSession session) {
		// to do some extra validations and create a new user!
		User user = userService.register(newUser, result);

		if (result.hasErrors()) {
			// Be sure to send in the empty LoginUser before
			// re-rendering the page.
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}

		// No errors!
		session.setAttribute("id", user.getId());
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
			session.setAttribute("id", user.getId());
			// in other words, log them in.
			Long id = (Long) session.getAttribute("id");
			model.addAttribute("user", userService.findUser(id));
			return "redirect:/view/user";
		}

	}

//	    Log out
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("id", null);
		return "redirect:/";
	}

}
