package com.ramirez.javaproject.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ramirez.javaproject.models.Bet;
import com.ramirez.javaproject.models.User;

@Repository
public interface BetRepository extends CrudRepository<Bet, Long>{
	List<Bet> findAll();
	
	Optional<Bet> findByUser(User user);
	
	List<Bet> findByGameId(Long id);
	
}
