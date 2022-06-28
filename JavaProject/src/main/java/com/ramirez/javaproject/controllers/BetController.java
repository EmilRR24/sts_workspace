package com.ramirez.javaproject.controllers;

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

import com.ramirez.javaproject.models.Bet;
import com.ramirez.javaproject.models.Game;
import com.ramirez.javaproject.services.BetService;
import com.ramirez.javaproject.services.GameService;

@Controller
public class BetController {
	//IMPORT SERVICES
	@Autowired
	private BetService betService;
	@Autowired
	private GameService gameService;
	
	// ------ CREATE -------- //
	@GetMapping("/gamelist")
	public String list(
			Model model,
			HttpSession session
			) {
		//CREATE OBJECT WITH GAMES THAT ARE NOT CLOSED
		List<Game> newGame = gameService.findNotUpdated();
		model.addAttribute("games", newGame);
		
		return "gameList.jsp";
	}
	
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
			
			return "bet.jsp";
		}
		//VALIDATIONS PASSED
		betService.createBet(completedBet);
		return "redirect:/bet/game/{id}";	
	}
	
	// ------ /CREATE -------- //
	
}
