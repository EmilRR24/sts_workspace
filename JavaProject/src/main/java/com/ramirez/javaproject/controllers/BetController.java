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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ramirez.javaproject.models.Bet;
import com.ramirez.javaproject.models.Game;
import com.ramirez.javaproject.models.User;
import com.ramirez.javaproject.services.BetService;
import com.ramirez.javaproject.services.GameService;
import com.ramirez.javaproject.services.UserService;

@Controller
public class BetController {
	//IMPORT SERVICES
	@Autowired
	private BetService betService;
	@Autowired
	private GameService gameService;
	@Autowired
	private UserService userService;
	
	// ------ CREATE -------- //
	@GetMapping("/gamelist")
	public String list(
			@ModelAttribute("betObj") Bet emptyBet,
			Model model,
			HttpSession session
			) {
		//CREATE OBJECT WITH GAMES THAT ARE NOT CLOSED
		List<Game> newGame = gameService.findNotCompleted();
		model.addAttribute("games", newGame);
		//CREATE USER OBJECT
		Long id = (long) session.getAttribute("user_id");
		User user = userService.findUser(id);
		model.addAttribute("userObj", user);
		
		return "gameList.jsp";
	}
	
	@GetMapping("/bet/new/{id}")
	public String bet(
			@PathVariable("id")Long id,
			@ModelAttribute("betObj") Bet emptyBet,
			Model model,
			HttpSession session
			) {
		//GRAB GAME OBJ
		Game game = gameService.findGame(id);
		//PASS GAME OBJ
		model.addAttribute("game", game);
		System.out.println(game);
		
		return "bet.jsp";
	}
	
	@PostMapping("/bet/new")
	public String createBet(
			@Valid @ModelAttribute("betObj") Bet completedBet,
			BindingResult results,
//			@PathVariable("id")Long game_id,
			Model model
			) {
		//BYPASS ERRORS LOADING AND JUST REDIRECT TO BET PAGE
		Game game = completedBet.getGame();
		Long game_id = game.getId();
		//VALIDATIONS FAILED
		if(results.hasErrors()) {
			//GRAB ALL ERRORS 
			List<Bet> allBet = betService.allBets();
			
			//PASS THE ERRORS TO JSP
			model.addAttribute("bets", allBet);
			
			
			return "redirect:/bet/new/"+game_id;
		}
		//VALIDATIONS PASSED
		betService.createBet(completedBet);
		
		Long betId = completedBet.getId();
		
		System.out.println("Bet ID is "+betId);
		System.out.println(completedBet);
		
		return "redirect:/bet/game/"+betId;	
	}
	
	// ------ /CREATE -------- //
	
}
