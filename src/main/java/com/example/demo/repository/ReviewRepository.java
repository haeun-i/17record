package com.example.demo.repository;
import com.example.demo.domain.Artist;
import com.example.demo.domain.Item;
import com.example.demo.domain.Review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review,Long>{
	Item findById(long id);
	void deleteById(Long id);
	
	@Query(value="select * from Review where item_id = :itemId", nativeQuery = true)
    List<Review> reviewList(@Param("itemId")Long itemId);
	

}
