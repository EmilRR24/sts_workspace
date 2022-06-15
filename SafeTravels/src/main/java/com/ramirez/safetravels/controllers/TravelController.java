package com.ramirez.safetravels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TravelController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
}
