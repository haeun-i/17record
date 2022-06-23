package com.example.demo.controller;
import com.example.demo.domain.*;
import com.example.demo.service.ArtistService;
import com.example.demo.service.ItemService;
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
public class ReviewController {

	@Resource
    private UserService userService;
	
	@Resource
    private ItemService itemService;
	
	@Resource
    private ReviewService reviewService;
	
    
	@RequestMapping("/reviewform")
	public String reviewform(Long id, Model model){
    	Item item = itemService.findItemById(id);
    	model.addAttribute("item", item);
    	model.addAttribute("artist", item.getArtist());
		model.addAttribute("reviewform",new ReviewForm());
		return "item/reviewAdd"; 
	}
	
	@RequestMapping("/reviewAdd")
	public String reviewAdd(HttpServletRequest request, ReviewForm reviewform, Long id, 
		HttpSession session, RedirectAttributes redirectAttributes){
		String logid = (String)session.getAttribute("id");
		User user = userService.findUserByLogId(logid);
		
		Item item = itemService.findItemById(id);
		Review review = new Review();
		review.setItem(item);
		review.setUser(user);
		review.setReviewDate(LocalDate.now());
		review.setReviewTitle(reviewform.getTitle());
		review.setReviewContent(reviewform.getContent());
		
		reviewService.save(review);
		
		redirectAttributes.addAttribute("id", id);
		return "redirect:/item";
	}

	@RequestMapping("/detailreview")
	public String detailreview(Long id, Model model){
		Review review = reviewService.findById(id).get();
		Item item = review.getItem();
		
    	model.addAttribute("review", review);
    	model.addAttribute("item", item);
    	model.addAttribute("artist", item.getArtist());
		return "item/review"; 
	}







}
