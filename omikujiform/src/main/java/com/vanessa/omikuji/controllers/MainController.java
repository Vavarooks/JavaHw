package com.vanessa.omikuji.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//Controller!
@Controller
public class MainController {
	@RequestMapping("/")
	public String index(Model model) {
		int[] nums = new int[26];
		for(int i=0;i<nums.length;i++) {
			nums[i] = i;
		}
		model.addAttribute("numbers", nums);
		return "index.jsp";
	}
//	Upload of Form Data
	@RequestMapping(value="/submit", method=RequestMethod.POST)
//	POST form info
	public String submit(@RequestParam(value = "number") int number,
						@RequestParam(value ="city") String city,
						@RequestParam(value ="name") String name,
						@RequestParam(value ="job") String job,
						@RequestParam(value ="things")String things,
						@RequestParam(value ="nice")String nice,
						HttpSession s) {
		
		//		Session Data
		s.setAttribute("number", number);	
		s.setAttribute("name", name);
		s.setAttribute("city",city);
		s.setAttribute("job", job);
		s.setAttribute("things", things);
		s.setAttribute("nice",nice);
		return "redirect:/complete";
		
	}
	
//	Display Form Data
	
	@RequestMapping("/complete")
	public String complete() {
		return "submit.jsp";
	}
	

}
