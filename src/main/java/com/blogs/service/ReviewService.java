package com.blogs.service;

import java.util.List;

import com.blogs.dto.ReviewDTO;

public interface ReviewService {

	ReviewDTO addReview(ReviewDTO reviewDTO);

	List<ReviewDTO> getAllReviews();

	ReviewDTO updateReview(Long id, ReviewDTO reviewDTO);

	void deleteReview(Long id);

}
