package com.ramirez.ninjagold.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoldController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

}
