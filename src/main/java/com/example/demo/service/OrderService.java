package com.example.demo.service;
import com.example.demo.domain.Artist;
import com.example.demo.domain.Item;
import com.example.demo.domain.Order;
import com.example.demo.domain.OrderDto;
import com.example.demo.domain.Review;
import com.example.demo.repository.ArtistRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
	
    @Autowired
    private OrderRepository orderRepository;

    public void save(Order order) {
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
}
