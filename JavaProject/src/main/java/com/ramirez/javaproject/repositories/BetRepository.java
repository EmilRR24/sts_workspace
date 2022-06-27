package com.ramirez.javaproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ramirez.javaproject.models.Bet;

@Repository
public interface BetRepository extends CrudRepository<Bet, Long>{
	List<Bet> findAll();
	
}
