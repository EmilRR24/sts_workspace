package com.ramirez.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ramirez.dojosninjas.models.Dojo;
import com.ramirez.dojosninjas.models.Ninja;
import com.ramirez.dojosninjas.services.DojoService;
import com.ramirez.dojosninjas.services.NinjaService;

@Controller
public class NinjaController {
	// IMPORT SERVICES
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	// ----- READ ----- //
	@GetMapping("/ninja")
	public String index(
			Model model,
			@ModelAttribute("ninjaObj") Ninja emptyNinja
			) {
		//GRAB ALL DOJOS FROM DB
		List<Dojo> allDojos = dojoService.allDojos();
		
		//PASS THE DOJOS TO JSP
		model.addAttribute("dojos", allDojos);
		
		return "ninja.jsp";
	}
	// ----- /READ ----- //
	// ------ CREATE -------- //
	@PostMapping("/ninja/new")
	public String createNinja(
			@Valid @ModelAttribute("ninjaObj") Ninja completedNinja,
			BindingResult results,
			Model model
			) {
		//VALIDATIONS FAILED
		if(results.hasErrors()) {
			//GRAB ALL ERRORS 
			List<Ninja> allNinjas = ninjaService.allNinjas();
			
			//PASS THE ERRORS TO JSP
			model.addAttribute("ninjas", allNinjas);
			//GRAB ALL DOJOA FROM DB
			List<Dojo> allDojos = dojoService.allDojos();
			
			//PASS THE DOJOS TO JSP
			model.addAttribute("dojos", allDojos);
			
			return "ninja.jsp";
		}
		//VALIDATIONS PASSED
		ninjaService.createNinja(completedNinja);
		return "redirect:/";	
	}
	
	// ------ /CREATE -------- //
}
