package com.example.demo.service;
import com.example.demo.domain.Artist;
import com.example.demo.domain.Item;
import com.example.demo.domain.ItemForm;
import com.example.demo.domain.Review;
import com.example.demo.domain.ReviewDto;
import com.example.demo.domain.SimpleItemDto;
import com.example.demo.repository.ArtistRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReviewService {
	
    @Autowired
    private ReviewRepository reviewRepository;
    
    public List<ReviewDto> findByItemId(Long id){
    	List<Review> reviews = reviewRepository.reviewList(id);
    	
		List<ReviewDto> realreviews = new ArrayList<>();
		for(Review r : reviews) {
			ReviewDto review = new ReviewDto();
			review.setReviewContent(r.getReviewContent());
			review.setReviewDate(r.getReviewDate());
			review.setReviewId(r.getReviewId());
			review.setUserName(r.getUser().getUserName());
			
			realreviews.add(review);
		}
		
		return realreviews;
    }
    
	public void save(Review review) {
		reviewRepository.save(review);
	}
}
