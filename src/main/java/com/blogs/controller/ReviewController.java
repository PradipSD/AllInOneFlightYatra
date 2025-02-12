package com.blogs.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.ReviewDTO;
import com.blogs.service.ReviewService;

import jakarta.validation.Valid;


@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/addReview")
	public ReviewDTO addReview(@Valid @RequestBody ReviewDTO reviewDTO) {
		return reviewService.addReview(reviewDTO);
	}

	@GetMapping("/getAllReviews")
	public List<ReviewDTO> getAllReviews(){
		return reviewService.getAllReviews();
	}

	@PutMapping("/updateReview/{id}")
	public ReviewDTO updateReview(@PathVariable Long id, @Valid @RequestBody ReviewDTO reviewDTO) {
		return reviewService.updateReview(id, reviewDTO);
	}

	@DeleteMapping("/deleteReview/{id}")
	public void deleteReview(@PathVariable Long id) {
		 reviewService.deleteReview(id);
	}
	

}
