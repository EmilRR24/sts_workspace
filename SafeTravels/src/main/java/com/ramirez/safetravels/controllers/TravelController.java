package com.ramirez.safetravels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ramirez.safetravels.models.Travel;
import com.ramirez.safetravels.services.TravelService;

@Controller
public class TravelController {
	// IMPORT SERVICES
	@Autowired
	private TravelService travelService;
	
	@RequestMapping("/")
	public String index(@ModelAttribute("travel")Travel travel) {
		return "index.jsp";
	}
	// ------ CREATE -------- //
	
	// ------ CREATE -------- //
	
	
	// ------ UPDATE -------- //
	@GetMapping("/edit/{id}")
	public String edit(
			@PathVariable("id") Long id,
			Model model
			){
		// Find one object from DB
		Travel editTravel = travelService.findTravel(id);
		// Pass the travel object to jsp
		model.addAttribute("travelObj", editTravel);
		
		return "edit.jsp";
	}
	// ------- UPDATE ------- //
}
