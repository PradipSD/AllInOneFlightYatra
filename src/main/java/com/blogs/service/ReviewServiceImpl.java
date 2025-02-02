package com.blogs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.dto.ReviewDTO;
import com.blogs.pojos.Review;
import com.blogs.repository.ReviewRepository;
import com.blogs.repository.UserRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public ReviewDTO addReview(ReviewDTO reviewDTO) {
		Review review  = modelMapper.map(reviewDTO, Review.class);
		Review savedreview = reviewRepository.save(review);
		return modelMapper.map(savedreview, ReviewDTO.class) ;
	}
	
	
	@Override
	public List<ReviewDTO> getAllReviews(){
		List<Review> reviews = reviewRepository.findAll();
		
		  return reviews.stream()
		            .map(r -> new ReviewDTO(
		                r.getReviewId(),
		                r.getRating(),
		                r.getReview(),
		                r.getReviewDate(),
		                r.getUser().getUserId(),
		                r.getUser().getFname(), 
		                r.getAirline().getAirlineId(),
		                r.getAirline().getAirlineName(), 
		                r.getFlight().getFlightId()

		            ))
		            .collect(Collectors.toList());
	}
	
	
	@Override
	public ReviewDTO updateReview(Long id,ReviewDTO reviewDTO) {
		Review review = reviewRepository.findById(id).orElseThrow();
		
		review.setRating(reviewDTO.getRating());
		review.setReview(reviewDTO.getReview());
//		review.getAirline().setAirlineName(reviewDTO.getAirlineName());;
		
		Review updateReview = reviewRepository.save(review);
		
		return modelMapper.map(updateReview, ReviewDTO.class);
		
	}
	
	@Override
	public void deleteReview(Long id) {
//		Review review = reviewRepository.findById(id).orElseThrow();
		reviewRepository.deleteById(id);
	}
}
