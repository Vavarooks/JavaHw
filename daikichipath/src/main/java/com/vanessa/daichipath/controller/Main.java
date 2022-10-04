package com.vanessa.daichipath.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class Main {
	
	@RequestMapping("")
	//	Main page :)
	public String index(){
		return " ~Welcome~ ";
	}
	
	//	for the today :D
	@RequestMapping("/today")
		public String today() {
			return " 🔮 Today you will find luck in all your endeavors!";
		}
	
	//	This is the tomorrow :3
	@RequestMapping("/tomorrow")
		public String tommorow() {
			return "🥠 Tomorrow, an opportunity will arise, so be sure to be open to new ideas~";
		}
	
	//The travel page plans :]
	@RequestMapping("/travel")
	public String travel(@RequestParam(value="q", required = false) String searchQuery) {
		return "Congratulations! You will soon travel ✈️ to " + searchQuery;
	}
	
	//unlucky message with the odds and evens!
	@RequestMapping("/lotto/{num}")
	public String lotto(@PathVariable("num") Integer num) {	
		if(num % 2 == 0) {
			return "🍀 You will take a grand journey near the future, but be wary of tempting offers. 🍀";
		}
		return "🐈‍⬛ You have enjoyed the fruits of your labor but now is a great tine to spend with family and friends. 🐈‍⬛";
	}
	
	//Ah got an error catcher here :/	
	@RequestMapping("/error")
	public String error() {
		return "Yikes! 😨 You got an Error~";
	}

}
