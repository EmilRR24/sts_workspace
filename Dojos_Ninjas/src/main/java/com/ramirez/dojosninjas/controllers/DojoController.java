package com.ramirez.dojosninjas.controllers;

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

import com.ramirez.dojosninjas.models.Dojo;
import com.ramirez.dojosninjas.services.DojoService;

@Controller
public class DojoController {
	// IMPORT SERVICES
	@Autowired
	private DojoService dojoService;
	
	// ------ READ ------- //
		@GetMapping("/")
		public String index(
				Model model,
				@ModelAttribute("dojoObj") Dojo emptyDojo
				) {
			//GRAB ALL DOJOS FROM DB
			List<Dojo> allDojos = dojoService.allDojos();
			
			//PASS THE ERRORS TO JSP
			model.addAttribute("dojos", allDojos);
			
			return "index.jsp";
		}
		
		@GetMapping("/dojo/{id}")
		public String getOne(
				@PathVariable("id") Long id,
				Model model
				) {
			//GRAB ONE DOJO FROM DB
			Dojo oneDojo = dojoService.findDojo(id);
			
			//PASS THE DOJO TO JSP
			model.addAttribute("dojo", oneDojo);
			
			return "dojo.jsp";
		}
		// ----- /READ ------- //
		
		// ------ CREATE -------- //
		@PostMapping("/new")
		public String createDojo(
				@Valid @ModelAttribute("dojoObj") Dojo completedDojo,
				BindingResult results,
				Model model
				) {
			//VALIDATIONS FAILED
			if(results.hasErrors()) {
				//GRAB ALL ERRORS 
				List<Dojo> allDojos = dojoService.allDojos();
				
				//PASS THE ERRORS TO JSP
				model.addAttribute("dojo", allDojos);
				return "index.jsp";
			}
			//VALIDATIONS PASSED
			dojoService.createDojo(completedDojo);
			return "redirect:/";	
		}
		
		// ------ /CREATE -------- //
}
