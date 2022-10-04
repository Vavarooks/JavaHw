package com.vanessa.Daichi_Routes.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//The main controller~

@RestController
@RequestMapping("/daikichi")
public class MainController{
	
	@RequestMapping("")
		public String index(){
			return " ~Welcome~ ";
//		Main page :)
		}
		
	@RequestMapping("/today")
		public String today() {
			return " 🔮 Today you will find luck in all your endeavors!";
//		for the today :D
		}
	@RequestMapping("/tomorrow")
		public String tommorow() {
			return "🥠 Tomorrow, an opportunity will arise, so be sure to be open to new ideas~";
//		This is the tomorrow :3
		}
	
}

