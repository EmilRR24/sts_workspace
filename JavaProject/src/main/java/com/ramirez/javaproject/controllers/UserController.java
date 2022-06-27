package com.ramirez.javaproject.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ramirez.javaproject.models.LoginUser;
import com.ramirez.javaproject.models.User;
import com.ramirez.javaproject.services.UserService;

@Controller
public class UserController {
	// DEPENDENCY INJECT
	@Autowired
	UserService userService;
	
	@GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
	
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
    	User user = userService.register(newUser, result);
        
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        Long id = newUser.getId();
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("user_id", user.getId());
        return "redirect:/account/"+id;
    }
	
	@PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
    	User user = userService.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("user_id", user.getId());
        
        Long userId = user.getId();
        
//        System.out.println(userId);
        return "redirect:/account/"+userId;
    }
    
    @GetMapping("logout")
    public String logout(
    		HttpSession session
    		){
    	session.invalidate();
    	return "redirect:/";
    }
	// ------ UPDATE -------- //
	@GetMapping("/account/{id}")
	public String edit(
			@PathVariable("id") Long id,
			Model model,
			HttpSession session
			){
		// Find one object from DB
		User editUser = userService.findUser(id);
		// Pass the travel object to jsp
		model.addAttribute("userObj", editUser);
		return "account.jsp";
	}
	@PutMapping("/account/{id}")
	public String update(
			HttpSession session,
			@PathVariable("id") Long id,
			@RequestParam(value="firstName") String firstName,
			@RequestParam(value="lastName") String lastName,
			@RequestParam(value="userName") String userName
			) {
		User editUser = userService.findUser(id);
		
		editUser.setFirstName(firstName);
		editUser.setLastName(lastName);
		editUser.setUserName(userName);
		editUser.setConfirm(editUser.getPassword());
		
		// VALIDATIONS HAVE FAILED

		
		// VALIDATIONS HAVE PASSED
		userService.updateUser(editUser);
		return "redirect:/account/"+editUser.getId();
	}
	// ------- /UPDATE ------- //
}
