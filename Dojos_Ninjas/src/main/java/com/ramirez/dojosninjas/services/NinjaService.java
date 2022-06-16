package com.ramirez.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ramirez.dojosninjas.models.Ninja;
import com.ramirez.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	//ADDING REPOSITORY AS A DEPENDENCY
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	//RETURNS ALL NINJAS
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	//CREATES A NINJA
	public Ninja createNinja(Ninja b) {
		return ninjaRepository.save(b);
	}
	//RETRIEVES A NINJA
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	//UPDATES A NINJA
	public Ninja updateNinja(Ninja updatedNinja) {
		return ninjaRepository.save(updatedNinja);
	}
	//DELETES A NINJA
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}
}
