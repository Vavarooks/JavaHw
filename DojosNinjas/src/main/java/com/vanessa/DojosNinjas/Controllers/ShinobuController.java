package com.vanessa.DojosNinjas.Controllers;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vanessa.DojosNinjas.Models.DojoModel;
import com.vanessa.DojosNinjas.Models.NinjaModel;
import com.vanessa.DojosNinjas.Services.DojoService;
import com.vanessa.DojosNinjas.Services.NinjaService;

@Controller
public class ShinobuController {
	@Autowired
	private DojoService dojoService;
	@Autowired
	private NinjaService ninjaService;
	
//	Home Page
	@RequestMapping("/")
	public String index (@ModelAttribute("dojoModel") DojoModel dojoModel ,Model model) {
		List<DojoModel> dojoModels = dojoService.allDojo();
		model.addAttribute("dojoModels", dojoModels);
		return "index.jsp";
	}
	
// Create Dojo
	@RequestMapping("/dojo")
	public String dojo (@Valid @ModelAttribute("dojoModel") DojoModel dojoModel,BindingResult result,RedirectAttributes flash ,Model model) {
		if(result.hasErrors()) {
			List<DojoModel> dojoModels = dojoService.allDojo();
			model.addAttribute("dojoModels", dojoModels);
			return "redirect:/";
			
		}
		else {
			DojoModel newDojo = dojoService.createDojo(dojoModel);
			
			return "redirect:/view/" + newDojo.getId();
		}
	}
	
//	View Dojo and it's Ninjas
	
	@GetMapping("/view/{id}")
	public String viewDojo(@PathVariable Long id, Model model) {
//		Pass in all Dojos
		DojoModel oneDojo = dojoService.findDojo(id);
		model.addAttribute("dojoModel",oneDojo);
		return "view.jsp";
	}
	
//	Create Ninja
	
	@GetMapping("/add/ninja")
	public String ninja (@ModelAttribute("ninjaModel") NinjaModel ninjaModel, BindingResult result, Model model) {
		
		model.addAttribute("dojoModels", dojoService.allDojo());
		return "ninja.jsp";
	}
	
	@PostMapping("/add/ninja")
	public String newNinja (@Valid @ModelAttribute("ninjaModel") NinjaModel ninjaModel, BindingResult result, RedirectAttributes flash,Model model) {
		if(result.hasErrors()) {
			List<NinjaModel> ninjaModels = ninjaService.allNinja();
			model.addAttribute("ninjaModel",ninjaModels);
			return "ninja.jsp";
		}
		else {
			ninjaService.createNinja(ninjaModel);
			return "redirect:/";
		}
	}

}
