package com.ramirez.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ramirez.dojosninjas.models.Dojo;
import com.ramirez.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	//ADDING REPOSITORY AS A DEPENDENCY
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	//RETURNS ALL DOJOS
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	//CREATES A DOJO
	public Dojo createDojo(Dojo b) {
		return dojoRepository.save(b);
	}
	//RETRIEVES A DOJO
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	//UPDATES A DOJO
	public Dojo updateDojo(Dojo updatedDojo) {
		return dojoRepository.save(updatedDojo);
	}
	//DELETES A DOJO
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}
}
