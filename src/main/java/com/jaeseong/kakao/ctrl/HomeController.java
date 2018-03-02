package com.jaeseong.kakao.ctrl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jaeseong.kakao.dto.MemberDTO;
import com.jaeseong.kakao.service.ChattingSerivce;
import com.jaeseong.kakao.service.MemberService;

@Controller
public class HomeController {
	
	@Autowired
	MemberService mservice;
	
	@Autowired
	ChattingSerivce cservice;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String go_login(Model model) {
		
		return "redirect:login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login_check(MemberDTO member, Model model, HttpSession session) {
		
		int result = mservice.member_check(member);
		String next_page = "redirect:friends";
		
		
		if(result!=1) {
			String msg = "Password is not equal. please Check your Password";
			if(result==-1) msg="Id is not exist. please Check your ID";
			next_page="login";
			
			model.addAttribute("msg", msg);
		}else {
			session.setAttribute("login_user", mservice.getLoginMember(member.getUserid()));
		}
		
		return next_page;
	}
	
	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	public String friends(Model model, HttpSession session) {
		
		if(session.getAttribute("login_user")==null) {
			model.addAttribute("msg", "Must Login for use this app");
			return "redirect:login";
		}
		
		model.addAttribute("login_member", session.getAttribute("login_user"));
		model.addAttribute("friends_list", mservice.getFriends((MemberDTO)session.getAttribute("login_user")));
		
		model.addAttribute("select_menu", 1);
		
		return "friends";
		
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Model model, @RequestParam int id, HttpSession session) {
		
		if(session.getAttribute("login_user")==null) {
			model.addAttribute("msg", "Must Login for use this app");
			return "redirect:login";
		}
		
		model.addAttribute("profile_member", mservice.getMemberbyId(id));
		
		return "profile";
		
	}
	
	@RequestMapping(value = "/chats", method = RequestMethod.GET)
	public String chats(Model model, HttpSession session) {
		
		if(session.getAttribute("login_user")==null) {
			model.addAttribute("msg", "Must Login for use this app");
			return "redirect:login";
		}
		
		MemberDTO mdto = (MemberDTO) session.getAttribute("login_user");
		
		model.addAttribute("chats_list", cservice.getAllChatList(mdto.getId()));
		
		model.addAttribute("select_menu", 2);
		
		return "chats";
		
	}
	
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String chat(Model model,@RequestParam int id, HttpSession session) {
		
		if(session.getAttribute("login_user")==null) {
			model.addAttribute("msg", "Must Login for use this app");
			return "redirect:login";
		}
		
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