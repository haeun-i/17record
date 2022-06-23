package com.example.demo.service;
import com.example.demo.domain.Item;
import com.example.demo.domain.ItemForm;
import com.example.demo.domain.SimpleItemDto;
import com.example.demo.domain.User;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ItemService {
	public List<Item> getItemList();
	
	public List<SimpleItemDto> recommendItem();
	public List<SimpleItemDto> getBoygroup();
	public List<SimpleItemDto> getGirlgroup();
	public List<SimpleItemDto> getBoysolo();
	public List<SimpleItemDto> getGirlsolo();
	public List<SimpleItemDto> getAbroad();
	public Item findItemById(long id);
	public void save(ItemForm itemform) throws Exception;
	public void modify(ItemForm itemform) throws Exception;
	public void edit(Item user);
	public void delete(long id);
}