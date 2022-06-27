package com.ramirez.javaproject.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.ramirez.javaproject.models.LoginUser;
import com.ramirez.javaproject.models.User;
import com.ramirez.javaproject.repositories.UserRepository;

@Service
public class UserService {
	// DEPENDENCY INJECT
	@Autowired
	UserRepository userRepo;
	
	// TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
    	// TO-DO - Reject values or register if no errors:
        
        // Reject if email is taken (present in database)
    	Optional<User> user = userRepo.findByEmail(newUser.getEmail());
    	
    	if(user.isPresent()) {
    		// USER EMAIL IS ALREADY TAKEN
    		result.rejectValue("email", "Duplicate", "Email is already taken");
    	}
        // Reject if USER NAME is taken (present in database)
    	Optional<User> userName = userRepo.findByUserName(newUser.getUserName());
    	
    	if(userName.isPresent()) {
    		// USER EMAIL IS ALREADY TAKEN
    		result.rejectValue("userName", "Duplicate", "User Name is already taken");
    	}
        // Reject if password doesn't match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
        // Return null if result has errors
    	if(result.hasErrors()) {
    		return null;
    	}
    
        // Hash and set password, save user to database
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	userRepo.save(newUser);
        return newUser;
    }
    
    public User login(LoginUser newLogin, BindingResult result) {
    	// TO-DO - Reject values:
        
    	// Find user in the DB by email
        // Reject if NOT present
    	
    	if(!this.checkEmail(newLogin.getEmail())) {
    		result.rejectValue("email", "Non-Existant", "INVALID CREDENTIALS");
    	}
    	if(result.hasErrors()) {
    		return null;
    	}
    	
        
        // Reject if BCrypt password match fails
    	User user = userRepo.findByEmail(newLogin.getEmail()).orElse(null);
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    
        // Return null if result has errors
    	if(result.hasErrors()) {
    		return null;
    	}
        // Otherwise, return the user object
        return user;
    }
    
    // CHECK EMAIL IS UNIQUE
    public boolean checkEmail(String email) {
    	Optional<User> user = userRepo.findByEmail(email);
    	
    	if(user.isPresent()) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    // CHECK USER NAME IS UNIQUE
    public boolean checkUserName(String userName) {
    	Optional<User> user = userRepo.findByUserName(userName);
    	
    	if(user.isPresent()) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
	//RETRIEVES A USER
	public User findUser(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
    
	//UPDATES A USER
	public User updateUser(User updatedUser) {
		return userRepo.save(updatedUser);
	}
}
