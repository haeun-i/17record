package com.example.demo.controller;
import com.example.demo.domain.*;
import com.example.demo.service.ArtistService;
import com.example.demo.service.ItemService;
import com.example.demo.service.OrderService;
import com.example.demo.service.ReviewService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.time.LocalDate;
import java.util.List;

@Controller
public class OrderController {

	@Resource
    private UserService userService;
	
	@Resource
    private ItemService itemService;
	
	@Resource
    private OrderService orderService;
    
	@RequestMapping("/orderform")
	public String orderform(Long id, Model model, HttpSession session){
		String logid = (String)session.getAttribute("id");
		User user = userService.findUserByLogId(logid);
    	Item item = itemService.findItemById(id);
    	
    	model.addAttribute("user", user);
    	model.addAttribute("item", item);
    	model.addAttribute("artist", item.getArtist());
    	model.addAttribute("orderform",new OrderForm());
    	
		return "order/orderform"; 
	}
	
	@RequestMapping("/orderAdd")
	public String orderAdd(OrderForm orderform, Long id, HttpSession session){
		String logid = (String)session.getAttribute("id");
		User user = userService.findUserByLogId(logid);
		Item item = itemService.findItemById(id);
		
		Order order = new Order();
		order.setItem(item);
		order.setOrderAddress(orderform.getOrderAddress());
		order.setOrderCount(orderform.getOrderCount());
		order.setOrderDate(LocalDate.now());
		order.setOrderName(orderform.getOrderName());
		order.setOrderPhone(orderform.getOrderPhone());
		order.setUser(user);
		order.setTotalPrice(item.getItemPrice() * orderform.getOrderCount());
		
		item.setItemStock(item.getItemStock()-1); 
		orderService.save(order);
		
		return "redirect:/";
	}
	
    @RequestMapping("/modifyOrderform")
    public String modifyOrderform(Long id, Model model){
    	Order order = orderService.findOrderById(id);
    	Item item = order.getItem();
    	OrderForm orderform = new OrderForm();
    	orderform.setOrderId(order.getOrderId());
    	orderform.setOrderAddress(order.getOrderAddress());
    	orderform.setOrderCount(order.getOrderCount());
    	orderform.setOrderName(order.getOrderName());
    	orderform.setOrderPhone(order.getOrderPhone());
    	
    	model.addAttribute("item", item);
    	model.addAttribute("artist", item.getArtist());
    	model.addAttribute("orderform", orderform);
        return "order/orderModify";
    }
	
    @RequestMapping("/modifyOrder")
    public String modifyOrder(OrderForm orderform) throws Exception{
    	orderService.modify(orderform);
        return "redirect:/adminorder";
    }
	
    @RequestMapping("/deleteOrder")
    public String delete(Long id){
        orderService.delete(id);
        return "redirect:/adminorder";
    }
    
    

}
