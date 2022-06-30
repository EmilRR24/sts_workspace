package com.ramirez.javaproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramirez.javaproject.models.Bet;
import com.ramirez.javaproject.models.User;
import com.ramirez.javaproject.repositories.BetRepository;

@Service
public class BetService {
	// DEPENDENCY INJECT
	@Autowired
	BetRepository betRepo;
	
	//RETURNS ALL BETS
	public List<Bet> allBets(){
		return betRepo.findAll();
	}
	//RETRIEVES ALL BETS BY GAME ID
	public List<Bet> allBetsByGame(Long id){
		return betRepo.findByGameId(id);
	}
	//RETRIEVES A BET
	public Bet findBetById(Long id) {
		Optional<Bet> optionalBet = betRepo.findById(id);
		if(optionalBet.isPresent()) {
			return optionalBet.get();
		} else {
			return null;
		}
	}

	
	//CREATES A BET
	public Bet createBet(Bet b) {
		return betRepo.save(b);
	}
}
