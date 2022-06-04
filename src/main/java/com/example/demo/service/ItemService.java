package com.example.demo.service;
import com.example.demo.domain.Item;
import com.example.demo.domain.ItemForm;
import com.example.demo.domain.User;
import java.util.List;

public interface ItemService {
	public List<Item> getItemList();
	public Item findItemById(long id);
	public void save(ItemForm itemform);
	public void edit(Item user);
	public void delete(long id);
}