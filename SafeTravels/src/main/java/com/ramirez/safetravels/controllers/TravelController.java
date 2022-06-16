package com.ramirez.safetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ramirez.safetravels.models.Travel;
import com.ramirez.safetravels.services.TravelService;

@Controller
public class TravelController {
	// IMPORT SERVICES
	@Autowired
	private TravelService travelService;
	
	// ------ READ ------- //
	@GetMapping("/")
	public String index(
			Model model,
			@ModelAttribute("travelObj") Travel emptyTravel
			) {
		//GRAB ALL TRAVELS FROM DB
		List<Travel> allTravels = travelService.allTravels();
		
		//PASS THE ERRORS TO JSP
		model.addAttribute("travels", allTravels);
		
		return "index.jsp";
	}
	
	@GetMapping("/{id}")
	public String getOne(
			@PathVariable("id") Long id,
			Model model
			) {
		//GRAB ONE TRAVEL FROM DB
		Travel oneTravel = travelService.findTravel(id);
		
		//PASS THE TRAVEL TO JSP
		model.addAttribute("travel", oneTravel);
		
		return "show.jsp";
	}
	// ----- READ ------- //
	
	// ------ CREATE -------- //
	@PostMapping("/new")
	public String createTravel(
			@Valid @ModelAttribute("travelObj") Travel completedTravel,
			BindingResult results,
			Model model
			) {
		//VALIDATIONS FAILED
		if(results.hasErrors()) {
			//GRAB ALL ERRORS 
			List<Travel> allTravels = travelService.allTravels();
			
			//PASS THE ERRORS TO JSP
			model.addAttribute("travels", allTravels);
			return "index.jsp";
		}
		//VALIDATIONS PASSED
		travelService.createTravel(completedTravel);
		return "redirect:/";	
	}
	
	// ------ /CREATE -------- //
	
	
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
	
	@PutMapping("/edit/{id}")
	public String update(
			@Valid @ModelAttribute("travelObj") Travel updatedTravel,
			BindingResult results
			) {
			// VALIDATIONS HAVE FAILED
			if(results.hasErrors()) {
				return "edit.jsp";
			}
			// VALIDATIONS HAVE PASSED
			travelService.updateTravel(updatedTravel);
			return "redirect:/";
	}
	// ------- /UPDATE ------- //

	// ------- DELETE ------- //
	@GetMapping("/delete/{id}")
	public String delete(
			@PathVariable("id") Long id
			) {
			travelService.deleteTravel(id);
			return "redirect:/";
	}
	// ------- /DELETE ------- //
}
