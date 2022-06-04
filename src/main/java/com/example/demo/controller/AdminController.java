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
public class AdminController {

	@Resource
	private UserService userService;

	@RequestMapping("/adminuser")
	public String userlist(Model model){
		List<User> users = userService.getUserList();
		model.addAttribute("users",users);
		return "admin/userlist"; 
	}
	
	@RequestMapping("/adminitem")
	public String userlist(Model model){
		List<User> users = userService.getUserList();
		model.addAttribute("users",users);
		return "admin/userlist"; 
	}
	
}
