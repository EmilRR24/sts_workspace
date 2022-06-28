package com.ramirez.javaproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramirez.javaproject.models.Game;
import com.ramirez.javaproject.repositories.GameRepository;

@Service
public class GameService {
	// DEPENDENCY INJECT
	@Autowired
	GameRepository gameRepo;
	
	//RETURNS ALL GAMES
	public List<Game> allGames(){
		return gameRepo.findAll();
	}
	
	//RETRIEVES A GAME
	public Game findGame(Long id) {
		Optional<Game> optionalGame = gameRepo.findById(id);
		if(optionalGame.isPresent()) {
			return optionalGame.get();
		} else {
			return null;
		}
	}
	//RETRIEVE A GAME NOT UPDATED
	public List<Game> findNotUpdated(){
		return gameRepo.findByUpdatedAtIsNull();
	}
	
	//CREATES A GAME
	public Game createGame(Game b) {
		return gameRepo.save(b);
	}
	
	//UPDATES A GAME
	public Game updateGame(Game updatedGame) {
		return gameRepo.save(updatedGame);
	}
	//DELETES A GAME
	public void deleteGame(Long id) {
		gameRepo.deleteById(id);
	}
	
	
	
}
