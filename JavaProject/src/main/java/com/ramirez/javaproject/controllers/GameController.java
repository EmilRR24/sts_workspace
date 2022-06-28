package com.ramirez.javaproject.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ramirez.javaproject.models.Game;
import com.ramirez.javaproject.services.GameService;
import com.ramirez.javaproject.services.GamerService;

@Controller
public class GameController {
	@Autowired
	GameService gameService;
	
	@Autowired
	GamerService gamerService;
	
	// ----- READ ----- //
	@GetMapping("/bet/game/{id}")
	public String getGame(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session
			) {
		
		return "userGame.jsp";
	}
	
	@GetMapping("/bet/game/{id}/result")
	public String getResult(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session
			) {
		
		return "result.jsp";
	}
	@GetMapping("/gamer/{id}")
	public String getGamer(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session
			) {
		//CREATE OBJECT WITH GAMES THAT ARE NOT CLOSED
		List<Game> newGame = gameService.findNotUpdated();
		model.addAttribute("games", newGame);
		
		System.out.println(newGame);
		
		return "gamerStream.jsp";
	}
	// ----- /READ ----- //
	
	// ----- CREATE ----- //
	@PostMapping("/gamer/{id}")
	public String newGame(
			@PathVariable("id") Long id,
			@RequestParam("user_id")Long user_id,
			@RequestParam("name")String name,
			@RequestParam("result") String result,
			Model model,
			HttpSession session
			) {
			//CREATE EMPTY GAMER
			Game newGame = new Game();
			//STORE NAME AND RESULT
			newGame.setName(name);
			newGame.setResult(result);
			//STORE USER OBJ
			newGame.setGamer(gamerService.findGamer(user_id));
			
			System.out.println(newGame);
			//CREATE GAME
			gameService.createGame(newGame);
			
			
			return "redirect:/gamer/" + id;
	
	}
	// ----- /CREATE ----- //
	
	// ----- UPDATE ----- //
	@PutMapping("/gamer/{id}")
	public String completeGame(
			@PathVariable("id") Long id,
			@RequestParam("result") String result,
			@RequestParam("game_id") Long game_id,
			Model model,
			HttpSession session
			) {
			//FIND GAME
			Game updatedGame = gameService.findGame(game_id);
			// UPDATE RESULT
			updatedGame.setResult(result);
			//SAVE GAME WITH UPDATE
			gameService.updateGame(updatedGame);
			
			return "redirect:/gamer/" + id;
	}
	
	
	
	// ----- /UPDATE ----- //
	
}
