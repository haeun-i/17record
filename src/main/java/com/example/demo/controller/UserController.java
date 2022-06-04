package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.LoginForm;
import com.example.demo.domain.User;
import com.example.demo.domain.UserForm;
import com.example.demo.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("/sign")
	public String sign(Model model, HttpSession session){
		model.addAttribute("userform",new UserForm());
		if(session != null) {
			System.out.println(session.getAttribute("id"));
		}
		return "user/sign"; 
	}
	
	@RequestMapping("/signAdmin")
	public String signAdmin(Model model){
		model.addAttribute("userform",new UserForm());
		return "user/signAdmin"; 
	}
	
	
	@RequestMapping("/add")
	public String add(UserForm userform){
		
		User user = new User();
		user.setUserLogid(userform.getLogid());
		user.setUserName(userform.getName());
		user.setUserPhone(userform.getPhone());
		user.setUserPw(userform.getPassword());
		user.setUserAddress(userform.getAddress());
		user.setUserRole("ROLE_USER");
		userService.save(user);
		
		return "redirect:/"; 
	}
	
	@RequestMapping("/add/admin")
	public String addAdmin(UserForm userform){
		
		User user = new User();
		user.setUserLogid(userform.getLogid());
		user.setUserName(userform.getName());
		user.setUserPhone(userform.getPhone());
		user.setUserPw(userform.getPassword());
		user.setUserAddress(userform.getAddress());
		user.setUserRole("ROLE_ADMIN");
		userService.save(user);
		
		return "redirect:/"; 
	}
	
	@RequestMapping("/login")
	public String login(Model model){
		model.addAttribute("loginform",new LoginForm());
		return "user/login"; 
	}
	
	@RequestMapping("/loginadmin")
	public String loginAdmin(Model model){
		model.addAttribute("loginform",new LoginForm());
		return "user/loginadmin"; 
	}
	
	@RequestMapping("/userlogin")
	public String login(LoginForm loginform, HttpSession session){
		if(userService.login(loginform)) {
			session.setAttribute("id", loginform.getLogid());
		}
		return "redirect:/"; 
	}
	
	@RequestMapping("/adminlogin")
	public String adminlogin(LoginForm loginform, HttpSession session){
		if(userService.loginAdmin(loginform)) {
			session.setAttribute("id", loginform.getLogid());
			return "redirect:/adminuser"; 
		}else {
			return "redirect:/loginadmin"; 
		}
		
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/"; 
	}
	
	@RequestMapping("/delete")
	public String edit(Long id){
		userService.delete(id);
		return "redirect:/adminuser";
	}

}
