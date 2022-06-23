package com.example.demo.service;

import com.example.demo.domain.Artist;
import com.example.demo.domain.Item;
import com.example.demo.domain.ItemForm;
import com.example.demo.domain.SimpleItemDto;
import com.example.demo.domain.User;
import com.example.demo.repository.ArtistRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private ArtistRepository artistRepository;

	@Override
	public List<Item> getItemList() {
		return itemRepository.findAll();
	}
	
	@Override
	public List<SimpleItemDto> recommendItem(){
		List<Item> items = itemRepository.recommendItem();
		List<SimpleItemDto> realItems = new ArrayList<>();
		for(Item i : items) {
			SimpleItemDto item = new SimpleItemDto();
			item.setItemId(i.getItemId());
			item.setItemImage(i.getItemImage());
			item.setItemName(i.getItemName());
			item.setItemPrice(i.getItemPrice());
			item.setArtistName(i.getArtist().getArtistName());
			
			realItems.add(item);
		}
		
		return realItems;
	}
	
	@Override
	public List<SimpleItemDto> getBoygroup() {
		List<Item> items = itemRepository.getBoygroup();
		List<SimpleItemDto> realItems = new ArrayList<>();
		for(Item i : items) {
			SimpleItemDto item = new SimpleItemDto();
			item.setItemId(i.getItemId());
			item.setItemImage(i.getItemImage());
			item.setItemName(i.getItemName());
			item.setItemPrice(i.getItemPrice());
			item.setArtistName(i.getArtist().getArtistName());
			
			realItems.add(item);
		}
		
		return realItems;
	}

	@Override
	public List<SimpleItemDto> getGirlgroup() {
		List<Item> items = itemRepository.getGirlgroup();
		List<SimpleItemDto> realItems = new ArrayList<>();
		for(Item i : items) {
			SimpleItemDto item = new SimpleItemDto();
			item.setItemId(i.getItemId());
			item.setItemImage(i.getItemImage());
			item.setItemName(i.getItemName());
			item.setItemPrice(i.getItemPrice());
			item.setArtistName(i.getArtist().getArtistName());
			
			realItems.add(item);
		}
		
		return realItems;
	}
	
	@Override
	public List<SimpleItemDto> getBoysolo() {
		List<Item> items = itemRepository.getBoysolo();
		List<SimpleItemDto> realItems = new ArrayList<>();
		for(Item i : items) {
			SimpleItemDto item = new SimpleItemDto();
			item.setItemId(i.getItemId());
			item.setItemImage(i.getItemImage());
			item.setItemName(i.getItemName());
			item.setItemPrice(i.getItemPrice());
			item.setArtistName(i.getArtist().getArtistName());
			
			realItems.add(item);
		}
		
		return realItems;
	}
	
	@Override
	public List<SimpleItemDto> getGirlsolo() {
		List<Item> items = itemRepository.getGirlsolo();
		List<SimpleItemDto> realItems = new ArrayList<>();
		for(Item i : items) {
			SimpleItemDto item = new SimpleItemDto();
			item.setItemId(i.getItemId());
			item.setItemImage(i.getItemImage());
			item.setItemName(i.getItemName());
			item.setItemPrice(i.getItemPrice());
			item.setArtistName(i.getArtist().getArtistName());
			
			realItems.add(item);
		}
		
		return realItems;
	}
	
	@Override
	public List<SimpleItemDto> getAbroad() {
		List<Item> items = itemRepository.getAbroad();
		List<SimpleItemDto> realItems = new ArrayList<>();
		for(Item i : items) {
			SimpleItemDto item = new SimpleItemDto();
			item.setItemId(i.getItemId());
			item.setItemImage(i.getItemImage());
			item.setItemName(i.getItemName());
			item.setItemPrice(i.getItemPrice());
			item.setArtistName(i.getArtist().getArtistName());
			
			realItems.add(item);
		}
		
		return realItems;
	}
	
	@Override
	public Item findItemById(long id) { return itemRepository.findById(id);	}

	@Override
	public void save(ItemForm itemform) throws Exception {
		Item item = new Item();
		Artist artist = artistRepository.FindArtist(itemform.getArtist());
		MultipartFile file = itemform.getImage();
		
		String projectpath = System.getProperty("user.dir") + "/src/main/resources/static/img";
		UUID uuid = UUID.randomUUID();
		String filename = uuid + "_" + file.getOriginalFilename();
		File saveFile = new File(projectpath, filename);
		file.transferTo(saveFile);
				
		item.setItemName(itemform.getName());
		item.setItemPrice(itemform.getPrice());
		item.setItemStock(itemform.getStock());
		item.setItemContent(itemform.getContent());
		item.setItemImage("/img/" + filename);
		item.setArtist(artist);
		
		itemRepository.save(item);
	}
	
	@Override
	public void modify(ItemForm itemform) throws Exception {
		Item item = itemRepository.findById(itemform.getItemId()).get();
		Artist artist = artistRepository.FindArtist(itemform.getArtist());
		MultipartFile file = itemform.getImage();
		
		String projectpath = System.getProperty("user.dir") + "/src/main/resources/static/img";
		UUID uuid = UUID.randomUUID();
		String filename = uuid + "_" + file.getOriginalFilename();
		File saveFile = new File(projectpath, filename);
		file.transferTo(saveFile);
				
		item.setItemName(itemform.getName());
		item.setItemPrice(itemform.getPrice());
		item.setItemStock(itemform.getStock());
		item.setItemContent(itemform.getContent());
		item.setItemImage("/img/" + filename);
		item.setArtist(artist);
		
		itemRepository.save(item);
		
	}

	@Override
	public void edit(Item item) {
		itemRepository.save(item);
	}

	@Override
	public void delete(long id) {
		itemRepository.deleteById(id);
	}
}