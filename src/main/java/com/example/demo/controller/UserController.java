package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.User;
import com.example.demo.domain.UserForm;
import com.example.demo.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("/sign")
	public String sign(Model model){
		model.addAttribute("userform",new UserForm());
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
	
	
	@RequestMapping("/delete")
	public String edit(Long id){
		userService.delete(id);
		return "redirect:/adminuser";
	}

}
