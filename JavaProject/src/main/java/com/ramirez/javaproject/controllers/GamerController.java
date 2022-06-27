package com.ramirez.javaproject.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ramirez.javaproject.models.Gamer;
import com.ramirez.javaproject.services.GamerService;
import com.ramirez.javaproject.services.UserService;

@Controller
public class GamerController {
	@Autowired
	GamerService gamerService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/account/gamer")
	public String newGamer(
			@RequestParam("user_id")Long user_id,
			@RequestParam("stream")String stream,
			Model model,
			HttpSession session
			) {
			//CREATE EMPTY GAMER
			Gamer newGamer = new Gamer();
			//STORE STREAM
			newGamer.setStream(stream);
			//STORE USER OBJ
			newGamer.setUser(userService.findUser(user_id));
			
			System.out.println(newGamer);
			//CREATE GAMER
			gamerService.createGamer(newGamer);
			
			Long id = user_id;
			
			return "redirect:/account/" + id;
	}
	
	@PutMapping("/account/gamer/edit")
	public String editGamer(
			@RequestParam("user_id")Long user_id,
			@RequestParam("stream")String stream,
			Model model,
			HttpSession session
			) {
			//FIND GAMER
			Gamer editGamer = gamerService.findGamer(user_id);
			//STORE NEW STREAM
			editGamer.setStream(stream);
			//SAVE GAMER
			gamerService.updateGamer(editGamer);
			
			Long id = user_id;
			
			return "redirect:/account/" + id;
		
	}
}
