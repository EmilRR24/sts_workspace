package com.ramirez.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ramirez.safetravels.models.Travel;
import com.ramirez.safetravels.repositories.TravelRepository;

@Service
public class TravelService {
	// adding the travel repository as a dependency
    private final TravelRepository travelRepository;
    
    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }
    // returns all the travels
    public List<Travel> allTravels() {
        return travelRepository.findAll();
    }
    // creates a travel
    public Travel createTravel(Travel b) {
        return travelRepository.save(b);
    }
    // retrieves a travel
    public Travel findTravel(Long id) {
        Optional<Travel> optionalTravel = travelRepository.findById(id);
        if(optionalTravel.isPresent()) {
            return optionalTravel.get();
        } else {
            return null;
        }
    }
    // updates a travel
    public Travel updateTravel(Travel updatedTravel) {
    	return travelRepository.save(updatedTravel);
    }
    // deletes a travel
    public void deleteTravel(Long id) {
    	travelRepository.deleteById(id);
    }
}
