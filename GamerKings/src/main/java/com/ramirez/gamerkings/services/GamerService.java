package com.ramirez.gamerkings.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramirez.gamerkings.models.Gamer;
import com.ramirez.gamerkings.repositories.GamerRepository;

@Service
public class GamerService {
	// DEPENDENCY INJECT
	@Autowired
	GamerRepository gamerRepo;
	
	//RETRIEVES A GAMER
	public Gamer findGamer(Long id) {
		Optional<Gamer> optionalGamer = gamerRepo.findById(id);
		if(optionalGamer.isPresent()) {
			return optionalGamer.get();
		} else {
			return null;
		}
	}
	//CREATES A GAMER
	public Gamer createGamer(Gamer b) {
		return gamerRepo.save(b);
	}
	
	//UPDATES A GAMER
	public Gamer updateGamer(Gamer updatedGamer) {
		return gamerRepo.save(updatedGamer);
	}
	
}
