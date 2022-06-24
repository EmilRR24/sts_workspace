package com.ramirez.gamerkings.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GameController {
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
		return "gamerStream.jsp";
	}
}
