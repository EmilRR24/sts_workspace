package com.ramirez.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoldController {
	@RequestMapping("/")
	public String index(
			HttpSession session
			) {
		ArrayList<String> activities = new ArrayList<String>();
	
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("activities", activities);
		}
		return "index.jsp";
	}
	@RequestMapping("/reset")
	public String reset(
			HttpSession session
			) {
		session.removeAttribute("gold");
		session.removeAttribute("activities");
		return "redirect:/";
	}
	@PostMapping("/farm")
	public String farm(
			HttpSession session
			) {
		Random rand = new Random();
		int amount = rand.nextInt(10,20+1);
		int total = (int) session.getAttribute("gold") + amount;
		session.setAttribute("gold", total);
		String activity = "FARM: You found " + amount + " gold! " + new Date();
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		activities.add(0, activity); 
		session.setAttribute("activities", activities);
		return "redirect:/";
	}
	@PostMapping("/cave")
	public String cave(
			HttpSession session
			) {
		Random rand = new Random();
		int amount = rand.nextInt(5,10+1);
		int total = (int) session.getAttribute("gold") + amount;
		session.setAttribute("gold", total);
		String activity = "CAVE: You found " + amount + " gold! " + new Date();
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		activities.add(0, activity); 
		session.setAttribute("activities", activities);
		return "redirect:/";
	}
	@PostMapping("/house")
	public String house(
			HttpSession session
			) {
		Random rand = new Random();
		int amount = rand.nextInt(2,5+1);
		int total = (int) session.getAttribute("gold") + amount;
		session.setAttribute("gold", total);
		String activity = "HOUSE: You found " + amount + " gold! " + new Date();
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		activities.add(0, activity); 
		session.setAttribute("activities", activities);
		return "redirect:/";
	}
	@PostMapping("/quest")
	public String quest(
			HttpSession session
			) {
		Random rand = new Random();
		int amount = rand.nextInt(-50,50+1);
		int total = (int) session.getAttribute("gold") + amount;
		session.setAttribute("gold", total);
		if(amount >= 0) {			
			String activity = "QUEST: You found " + amount + " gold! " + new Date();
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add(0, activity); 
			session.setAttribute("activities", activities);
			return "redirect:/";
		}
		String activity = "QUEST: You lost " + amount + " gold! " + new Date();
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		activities.add(0, activity); 
		session.setAttribute("activities", activities);
		return "redirect:/";
	}
}
