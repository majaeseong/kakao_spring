package com.jaeseong.kakao;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "login";
	}
	
	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	public String friends(Model model) {
		
		model.addAttribute("select_menu", 1);
		
		return "friends";
		
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Model model) {
		
		return "profile";
		
	}
	
	@RequestMapping(value = "/chats", method = RequestMethod.GET)
	public String chats(Model model) {
		
		model.addAttribute("select_menu", 2);
		
		return "chats";
		
	}
	
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String chat(Model model) {
		
		return "chat";
		
	}
	
	@RequestMapping(value = "/more", method = RequestMethod.GET)
	public String more(Model model) {
		
		model.addAttribute("select_menu", 3);
		
		return "more";
		
	}
	
	@RequestMapping(value = "/setting", method = RequestMethod.GET)
	public String setting(Model model) {
		
		model.addAttribute("select_menu", 4);
		
		return "setting";
		
	}	
	
}
