package com.ramirez.daikichi.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/show")
	public String show() {
		return "show.jsp";
	}
	@PostMapping("/submit")
	public String submitData(
			@RequestParam(value="number") int number,
			@RequestParam(value="city") String city,
			@RequestParam(value="name") String name,
			@RequestParam(value="profession") String profession,
			@RequestParam(value="thing") String thing,
			@RequestParam(value="nice") String nice,
			HttpSession session
			) {
		boolean numberSize = true;
		if(number < 5 || number > 25) {
			numberSize = false;
		}
		if(numberSize == false) {
			return "redirect:/";
		}
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("profession", profession);
		session.setAttribute("thing", thing);
		session.setAttribute("nice", nice);
		return "redirect:/show";
	}

}
