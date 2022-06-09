package com.example.demo.repository;
import com.example.demo.domain.Artist;
import com.example.demo.domain.Item;
import com.example.demo.domain.Order;
import com.example.demo.domain.Review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order,Long>{
}
