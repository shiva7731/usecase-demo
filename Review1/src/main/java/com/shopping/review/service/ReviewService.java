package com.shopping.review.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.shopping.review.model.Review;

public interface ReviewService {
	
	// Save operation
	public Review saveReview(Review Review);

	// Read operation
	public Review getReviewById(long ReviewId) ;
	
	// Read operation
	public List<Review> fetchReviewList(Pageable page);

	// Update operation
	public Review updateReview(Review Review,long ReviewId);

	// Delete operation
	public void deleteReviewById(long ReviewId);


	// Read operation
	public List<Review> findAllReviewUsersNative(String username);


	// Read operation
	public List<Review> findAllReviewNative(String productId);

}
