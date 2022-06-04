package com.example.demo.controller;
import com.example.demo.domain.*;
import com.example.demo.service.ArtistService;
import com.example.demo.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ItemController {

    @Resource
    private ItemService itemService;

    @Resource
    private ArtistService artistService;

    @RequestMapping("/itemform")
    public String sign(Model model){
        List<Artist> artists = artistService.getArtistList();
        model.addAttribute("artists", artists);
        model.addAttribute("itemform",new ItemForm());
        return "item/itemAdd";
    }

    @RequestMapping("/addItem")
    public String add(ItemForm itemform){
    	itemService.save(itemform);
        return "redirect:/adminitem";
    }


    @RequestMapping("/deleteItem")
    public String delete(Long id){
        itemService.delete(id);
        return "redirect:/adminitem";
    }

}
