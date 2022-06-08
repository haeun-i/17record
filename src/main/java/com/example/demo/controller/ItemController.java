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

import com.example.demo.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ItemController {

    @Resource
    private ItemService itemService;

    @Resource
    private ArtistService artistService;
    
    @Resource
    private ReviewService reviewService;

    @RequestMapping("/item")
    public String item(Long id, Model model){
    	Item item = itemService.findItemById(id);
    	List<ReviewDto> reviews = reviewService.findByItemId(item.getItemId());
    	model.addAttribute("review", reviews);
    	model.addAttribute("item", item);
    	model.addAttribute("artist", item.getArtist());
        return "item/item";
    }
    
    @RequestMapping("/itemform")
    public String sign(Model model){
        List<Artist> artists = artistService.getArtistList();
        model.addAttribute("artists", artists);
        model.addAttribute("itemform",new ItemForm());
        return "item/itemAdd";
    }

    @RequestMapping("/addItem")
    public String add(ItemForm itemform) throws Exception{
    	itemService.save(itemform);
        return "redirect:/adminitem";
    }


    @RequestMapping("/deleteItem")
    public String delete(Long id){
        itemService.delete(id);
        return "redirect:/adminitem";
    }
    
    @RequestMapping("/showboygroup")
    public String showBoygroup(Model model){
    	List<SimpleItemDto> items = itemService.getBoygroup();
    	model.addAttribute("items", items);
    	model.addAttribute("itemform",new ItemForm());
        return "item/showAllItems";
    }
    
    @RequestMapping("/showgirlgroup")
    public String showGirlgroup(Model model){
    	List<SimpleItemDto> items = itemService.getGirlgroup();
    	model.addAttribute("items", items);
    	model.addAttribute("itemform",new ItemForm());
        return "item/showAllItems";
    }
    
    @RequestMapping("/showboysolo")
    public String showBoysolo(Model model){
    	List<SimpleItemDto> items = itemService.getBoysolo();
    	model.addAttribute("items", items);
    	model.addAttribute("itemform",new ItemForm());
        return "item/showAllItems";
    }
    
    @RequestMapping("/showgirlsolo")
    public String showGirlsolo(Model model){
    	List<SimpleItemDto> items = itemService.getGirlsolo();
    	model.addAttribute("items", items);
    	model.addAttribute("itemform",new ItemForm());
        return "item/showAllItems";
    }
    
    @RequestMapping("/showabroad")
    public String showAbroad(Model model){
    	List<SimpleItemDto> items = itemService.getAbroad();
    	model.addAttribute("items", items);
    	model.addAttribute("itemform",new ItemForm());
        return "item/showAllItems";
    }



}
