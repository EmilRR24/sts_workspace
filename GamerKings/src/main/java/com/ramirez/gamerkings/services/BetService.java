package com.ramirez.gamerkings.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramirez.gamerkings.models.Bet;
import com.ramirez.gamerkings.repositories.BetRepository;

@Service
public class BetService {
	// DEPENDENCY INJECT
	@Autowired
	BetRepository betRepo;
	
	//RETURNS ALL BETS
	public List<Bet> allBets(){
		return betRepo.findAll();
	}
	
	//RETRIEVES A BET
	public Bet findBet(Long id) {
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
