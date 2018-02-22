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
		
		return "friends";
		
	}
	
	@RequestMapping(value = "/chats", method = RequestMethod.GET)
	public String chats(Model model) {
		
		return "chats";
		
	}
	
	@RequestMapping(value = "/more", method = RequestMethod.GET)
	public String more(Model model) {
		
		return "more";
		
	}
	
}
