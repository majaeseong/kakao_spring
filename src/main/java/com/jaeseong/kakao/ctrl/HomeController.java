package com.jaeseong.kakao.ctrl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jaeseong.kakao.dto.ChattingDTO;
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
	public String go_login(Model model, HttpSession session) {
		
		if(session.getAttribute("login_user")!=null) {
			return "redirect:friends";
		}
		
		return "redirect:login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		
		if(session.getAttribute("login_user")!=null) {
			return "redirect:friends";
		}
		
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
		MemberDTO mdto = (MemberDTO) session.getAttribute("login_user");
		model.addAttribute("login_member", mservice.getMemberbyId(mdto.getId()));
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
		
		model.addAttribute("login_member", session.getAttribute("login_user"));
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
		
		MemberDTO mdto = (MemberDTO) session.getAttribute("login_user");
		
		model.addAttribute("chatList", cservice.getAllchatting(mdto.getId(),id));
		model.addAttribute("contact_member", mservice.getMemberbyId(id));
		model.addAttribute("login_member", mdto); //login user
		
		return "chat";
		
	}
	
	@RequestMapping(value = "/addChatText")
	public String addChatText(Model model,ChattingDTO cdto) {
		
		cservice.addChatText(cdto);
		model.addAttribute("id", cdto.getRes_id());
		
		return "redirect:chat";
		
	}
	
	
	
	@RequestMapping(value = "/more", method = RequestMethod.GET)
	public String more(Model model) {
		
		model.addAttribute("select_menu", 3);
		
		return "more";
		
	}
	
	@RequestMapping(value = "/setting", method = RequestMethod.GET)
	public String setting(Model model, HttpSession session) {
		
		if(session.getAttribute("login_user")==null) {
			model.addAttribute("msg", "Must Login for use this app");
			return "redirect:login";
		}
		MemberDTO mdto = (MemberDTO) session.getAttribute("login_user");
		model.addAttribute("login_member", mservice.getMemberbyId(mdto.getId()));
		model.addAttribute("select_menu", 4);
		
		return "setting";
		
	}
	
	@RequestMapping(value="/edit_profile", method=RequestMethod.POST)
	public String edit_profile(MemberDTO mdto) {
		
		mservice.edit_profile(mdto);

		return "redirect:setting";
	}
	
	@RequestMapping(value="/logout")
	public String logout(Model model, HttpSession session) {
		
		if(session!=null)
			session.invalidate();
		
		model.addAttribute("msg", "Success Logout safely, Please Meet again!");

		return "redirect:login";
	}
	
}
