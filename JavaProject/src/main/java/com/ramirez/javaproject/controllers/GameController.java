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

import com.ramirez.javaproject.models.Bet;
import com.ramirez.javaproject.models.Game;
import com.ramirez.javaproject.models.Gamer;
import com.ramirez.javaproject.models.User;
import com.ramirez.javaproject.services.BetService;
import com.ramirez.javaproject.services.GameService;
import com.ramirez.javaproject.services.GamerService;
import com.ramirez.javaproject.services.UserService;

@Controller
public class GameController {
	@Autowired
	GameService gameService;
	
	@Autowired
	GamerService gamerService;
	
	@Autowired
	BetService betService;
	
	@Autowired
	UserService userService;
	
	// ----- READ ----- //
	@GetMapping("/bet/game/{id}")
	public String getGame(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session
			) {
		//GET USER ID
		Long user_id = (Long) session.getAttribute("user_id");
		//GET USER OBJECT
		User user = userService.findUser(user_id);
		//GET BET BY BETID
		Bet currentBet = betService.findBetById(id);
		model.addAttribute("currentBet",currentBet);
		//GET ALL BETS BY GAME ID
		Game game = currentBet.getGame();
		Long gameId = game.getId();
		List<Bet> allBets = betService.allBetsByGame(gameId);
		int numberOfBets = allBets.size();
		//PASS ALLBETS TO JSP
		model.addAttribute("allBets",numberOfBets);

		
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
		//GET GAMER BY ID
		Gamer gamer = gamerService.findGamer(id);
		//CREATE OBJECT WITH GAMES THAT ARE NOT UPDATED
		Game newGame = gameService.findNotUpdated(gamer);
		model.addAttribute("game", newGame);
		
		//CREATE OBJECT WITH ALL GAMES UPDATED
		List<Game> historyGames = gameService.findUpdated();
		model.addAttribute("historyGames", historyGames);
		//CREATE OBJECT WITH GAMES NOT COMPLETED
		List<Game> notCompleted = gameService.findNotCompleted();
		model.addAttribute("notCompleted", notCompleted);
		
		//CREATE OBJECT WITH GAMES NOT COMPLETED AND UPDATED
		List<Game> notPaid = gameService.findNotCompletedAndUpdated();
		model.addAttribute("notPaid", notPaid);
		
		//GET ALL BETS BY GAME ID
		int numberOfBets = 0;
		if(newGame != null) {
		Long gameId = newGame.getId();
			List<Bet> allBets = betService.allBetsByGame(gameId);
			numberOfBets = allBets.size();
		}
		model.addAttribute("allBets",numberOfBets);

		
		//PASS ALLBETS TO JSP
		
		model.addAttribute("historyGames", historyGames);
		
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
			

			//CREATE GAME
			gameService.createGame(newGame);
			session.setAttribute("game", newGame);
			
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
			//FIND ALL BETS WITH GAME ID

			return "redirect:/gamer/" + id;
	}
	@PutMapping("/gamer/{id}/payout")
	public String payOut(
			@PathVariable("id") Long id,
			@RequestParam("completed") String completed,
			@RequestParam("game_id") Long game_id,
			Model model,
			HttpSession session
			) {
			//FIND GAME
			Game updatedGame = gameService.findGame(game_id);
			// UPDATE RESULT
			updatedGame.setCompleted(completed);
			//SAVE GAME WITH UPDATE
			gameService.updateGame(updatedGame);
			
			return "redirect:/gamer/" + id;
	}
	
	
	
	// ----- /UPDATE ----- //
	
}
