package com.example.demo.service;
import com.example.demo.domain.Artist;
import com.example.demo.domain.Item;
import com.example.demo.domain.ItemForm;
import com.example.demo.domain.Order;
import com.example.demo.domain.OrderDto;
import com.example.demo.domain.OrderForm;
import com.example.demo.domain.Review;
import com.example.demo.repository.ArtistRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
	
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private ItemRepository itemRepository;

    public void save(Order order) {
		orderRepository.save(order);
	}
    
    
	public void modify(OrderForm orderform){
		System.out.println(orderform.getOrderId());
		Order order = orderRepository.findById(orderform.getOrderId()).get();

		
		order.setOrderAddress(orderform.getOrderAddress());
		order.setOrderCount(orderform.getOrderCount());
		order.setOrderDate(LocalDate.now());
		order.setOrderName(orderform.getOrderName());
		order.setOrderPhone(orderform.getOrderPhone());
		order.setTotalPrice(order.getItem().getItemPrice() * orderform.getOrderCount());
		
		orderRepository.save(order);
		
	}
	
	public List<OrderDto> getOrderList() {
		List<Order> orders = orderRepository.findAll();
		List<OrderDto> realorders = new ArrayList<>();
		
		for(Order o : orders) {
			OrderDto order = new OrderDto();
			order.setItemName(o.getItem().getItemName());
			order.setOrderAddress(o.getOrderAddress());
			order.setOrderCount(o.getOrderCount());
			order.setOrderDate(o.getOrderDate());
			order.setOrderId(o.getOrderId());
			order.setOrderName(o.getOrderName());
			order.setOrderPhone(o.getOrderPhone());
			order.setTotalPrice(o.getTotalPrice());
			
			realorders.add(order);
		}
		return realorders;
	}
	
	public List<OrderDto> changeToDto(List<Order> orders) {
		List<OrderDto> realorders = new ArrayList<>();
		
		for(Order o : orders) {
			OrderDto order = new OrderDto();
			order.setItemName(o.getItem().getItemName());
			order.setOrderAddress(o.getOrderAddress());
			order.setOrderCount(o.getOrderCount());
			order.setOrderDate(o.getOrderDate());
			order.setOrderId(o.getOrderId());
			order.setOrderName(o.getOrderName());
			order.setOrderPhone(o.getOrderPhone());
			order.setTotalPrice(o.getTotalPrice());
			
			realorders.add(order);
		}
		return realorders;
	}
	
	public Order findOrderById(long id) { 
		return orderRepository.findById(id);	
	}
	
	public void delete(long id) {
		orderRepository.deleteById(id);
	}
	
	
}
