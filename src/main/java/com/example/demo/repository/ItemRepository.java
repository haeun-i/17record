package com.example.demo.repository;
import com.example.demo.domain.Artist;
import com.example.demo.domain.Item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item,Long>{
	Item findById(long id);
	void deleteById(Long id);
	
	@Query(value="select * from Item where artist_id IN (select artist_id from Artist where category='남자그룹')", nativeQuery = true)
    List<Item> getBoygroup();
	
	@Query(value="select * from Item where artist_id IN (select artist_id from Artist where category='여자그룹')", nativeQuery = true)
    List<Item> getGirlgroup();
	
	@Query(value="select * from Item where artist_id IN (select artist_id from Artist where category='남자솔로')", nativeQuery = true)
    List<Item> getBoysolo();
	
	@Query(value="select * from Item where artist_id IN (select artist_id from Artist where category='여자솔로')", nativeQuery = true)
    List<Item> getGirlsolo();
	
	@Query(value="select * from Item where artist_id IN (select artist_id from Artist where category='해외음악')", nativeQuery = true)
    List<Item> getAbroad();
	
	// 추천 음반 두개
	@Query(value="select * from Item order by rand() limit 2", nativeQuery = true)
    List<Item> recommendItem();
}
