package com.ctwyrth.ninjagold.controllers;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	ArrayList<String> actions = new ArrayList<String>();
	
    @GetMapping("/")
    public String index(HttpSession session, Model model) {
    	LocalDateTime timestamp = LocalDateTime.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy h:mm a");
    	
    	if (session.getAttribute("gold") == null) {
            session.setAttribute("gold", 0);
        }
    	
    	if (session.getAttribute("actions") == null) {
    		String startQuest = "You're quest to make gold has begun. (" + timestamp.format(formatter) + ")\n";
    		actions.add(0, startQuest);
    		session.setAttribute("actions", actions);
    	}
    	
    	model.addAttribute("gold", session.getAttribute("gold"));
    	model.addAttribute("actions", session.getAttribute("actions"));
    	
        return "index.jsp";
    }
    
    @PostMapping("/addGold")
    public String addGold(@RequestParam("name") String name, HttpSession session) {
    	LocalDateTime timestamp = LocalDateTime.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy h:mm a");
    	Random goldRandom = new Random();
    	
    	
    	if (name.equals("farm")) {
    		Integer newGold = goldRandom.ints(10, (20 + 1)).findFirst().getAsInt();
    		Integer gold = (Integer) session.getAttribute("gold");
    		String updatedStr = "\u001B[32mThe farm made: " + newGold + " gold (" + timestamp.format(formatter) + ")\u001B[0m";
    		actions.add(0, updatedStr);
//    		session.setAttribute("actions",  updatedStr);
    		session.setAttribute("gold", (gold + newGold));
    	} else if (name.equals("cave")) {
    		Integer newGold = goldRandom.ints(5, (10 + 1)).findFirst().getAsInt(); 
    		Integer gold = (Integer) session.getAttribute("gold");
    		String updatedStr = "The cave made: " + newGold + " gold (" + timestamp.format(formatter) + ")";
    		actions.add(0, updatedStr);
//    		session.setAttribute("actions",  updatedStr);
    		session.setAttribute("gold", (gold + newGold));
    	} else if (name.equals("house")) {
    		Integer newGold = goldRandom.ints(2, (5 + 1)).findFirst().getAsInt();
    		Integer gold = (Integer) session.getAttribute("gold");
    		String updatedStr = "The house made: " + newGold + " gold (" + timestamp.format(formatter) + ")";
    		actions.add(0, updatedStr);
//    		session.setAttribute("actions",  updatedStr);
    		session.setAttribute("gold", (gold + newGold));
    	} else if (name.equals("quest")) {
    		int winLose = (int) Math.floor(Math.random() * 10 + 1);
    		if (winLose <= 5) {
    			Integer newGold = goldRandom.ints(10, (20 + 1)).findFirst().getAsInt();
        		Integer gold = (Integer) session.getAttribute("gold");
        		String updatedStr = "The quest lost: " + newGold + " gold (" + timestamp.format(formatter) + ")";
        		actions.add(0, updatedStr);
//        		session.setAttribute("actions",  updatedStr);
        		session.setAttribute("gold", (gold - newGold));
    		} else if (winLose > 5) {
	    		Integer newGold = goldRandom.ints(10, (20 + 1)).findFirst().getAsInt();
	    		Integer gold = (Integer) session.getAttribute("gold");
	    		String updatedStr = "The quest made: " + newGold + " gold (" + timestamp.format(formatter) + ")";
	    		actions.add(0, updatedStr);
//	    		session.setAttribute("actions",  updatedStr);
	    		session.setAttribute("gold", (gold + newGold));
    		}
    	}
    	return "redirect:/";
    }
    
    @GetMapping("/reset")
    public String reset(HttpSession session) {
    	actions.clear();
    	session.invalidate();
    	return "redirect:/";
    }

}
