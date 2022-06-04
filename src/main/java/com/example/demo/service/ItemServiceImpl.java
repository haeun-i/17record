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

import java.util.List;

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
	public void save(ItemForm itemform) {
		Item item = new Item();
		Artist artist = artistRepository.FindArtist(itemform.getArtist());
		
		item.setItemName(itemform.getName());
		item.setItemPrice(itemform.getPrice());
		item.setItemStock(itemform.getStock());
		item.setItemContent(itemform.getContent());
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