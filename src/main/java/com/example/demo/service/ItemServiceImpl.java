package com.example.demo.service;

import com.example.demo.domain.Artist;
import com.example.demo.domain.Item;
import com.example.demo.domain.ItemForm;
import com.example.demo.domain.User;
import com.example.demo.repository.ArtistRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
	public void edit(Item item) {
		itemRepository.save(item);
	}

	@Override
	public void delete(long id) {
		itemRepository.deleteById(id);
	}
}