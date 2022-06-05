package com.example.demo.service;
import com.example.demo.domain.Item;
import com.example.demo.domain.ItemForm;
import com.example.demo.domain.User;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ItemService {
	public List<Item> getItemList();
	public Item findItemById(long id);
	public void save(ItemForm itemform) throws Exception;
	public void edit(Item user);
	public void delete(long id);
}