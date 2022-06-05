package com.example.demo.repository;

import com.example.demo.domain.Artist;
import com.example.demo.domain.Item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArtistRepository extends JpaRepository<Artist,Long> {
	void deleteById(Long id);
	
	@Query(value="select * from Artist where artist_name = :artistName", nativeQuery = true)
    Artist FindArtist(@Param("artistName")String artistName);
	
	@Query(value="select * from Artist where category = '남자그룹'", nativeQuery = true)
    Artist FindBoyGroup();
}