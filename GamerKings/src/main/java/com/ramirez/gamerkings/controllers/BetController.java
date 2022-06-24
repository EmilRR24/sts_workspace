package com.ramirez.gamerkings.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ramirez.gamerkings.models.Bet;
import com.ramirez.gamerkings.services.BetService;

@Controller
public class BetController {
	//IMPORT SERVICES
	@Autowired
	private BetService betService;
	
	// ------ CREATE -------- //
	@GetMapping("/bet")
	public String bet(
			@ModelAttribute("betObj") Bet emptyBet
			) {
		return "bet.jsp";
	}
	@PostMapping("/bet/new")
	public String createBet(
			@Valid @ModelAttribute("betObj") Bet completedBet,
			BindingResult results,
			Model model
			) {
		//VALIDATIONS FAILED
		if(results.hasErrors()) {
			//GRAB ALL ERRORS 
			List<Bet> allBet = betService.allBets();
			
			//PASS THE ERRORS TO JSP
			model.addAttribute("bets", allBet);
			
			return "dashboard.jsp";
		}
		//VALIDATIONS PASSED
		betService.createBet(completedBet);
		return "redirect:/bet/game/{id}";	
	}
	
	// ------ /CREATE -------- //
}
