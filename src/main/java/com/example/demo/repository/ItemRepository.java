package com.example.demo.repository;
import com.example.demo.domain.Artist;
import com.example.demo.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item,Long>{
	Item findById(long id);
	void deleteById(Long id);
	
	@Query(value="select * from Item where artist_name = :artistName", nativeQuery = true)
    Item getBoygroup();
	
	
}
