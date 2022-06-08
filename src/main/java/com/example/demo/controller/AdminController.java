package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Item;
import com.example.demo.domain.ItemForm;
import com.example.demo.domain.SimpleItemDto;
import com.example.demo.domain.User;
import com.example.demo.domain.UserForm;
import com.example.demo.service.ItemService;
import com.example.demo.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class AdminController {

	@Resource
	private UserService userService;
	
	@Resource
	private ItemService itemService;
	
	@RequestMapping("/")
	public String indexPage(Model model){
    	List<SimpleItemDto> items = itemService.recommendItem();
    	model.addAttribute("items", items);
		return "index"; 
	}
	

	@RequestMapping("/adminuser")
	public String userlist(Model model){
		List<User> users = userService.getUserList();
		model.addAttribute("users",users);
		return "admin/userlist"; 
	}
	
	@RequestMapping("/adminitem")
	public String itemlist(Model model){
		List<Item> items = itemService.getItemList();
		model.addAttribute("items",items);
		return "admin/itemlist"; 
	}
	
}
