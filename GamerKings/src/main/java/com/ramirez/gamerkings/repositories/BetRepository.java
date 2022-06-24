package com.ramirez.gamerkings.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ramirez.gamerkings.models.Bet;

@Repository
public interface BetRepository extends CrudRepository<Bet, Long>{
	List<Bet> findAll();
	
}
