package com.shopping.review.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shopping.review.exception.ResourceNotFoundException;
import com.shopping.review.model.Review;
import com.shopping.review.service.ReviewService;
import com.shopping.review.repository.ReviewRepository;

//Annotation
@Service

//Class
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	// Save operation
	@Override
	public Review saveReview(Review Review)
	{
		return reviewRepository.save(Review);
	}

	// Read operation
	@Override
	public Review getReviewById(long ReviewId) {
		long id = ReviewId;
		Optional<Review> review = reviewRepository.findById(id);
		if(review.isPresent())
			return review.get();
		throw new ResourceNotFoundException("Review Not Found For This ID");
	} 
	
	// Read operation
	@Override public List<Review> fetchReviewList(Pageable page)
	{
		return (List<Review>)
				reviewRepository.findAll(page).toList();
	}

	// Update operation
	@Override
	public Review updateReview(Review Review,long ReviewId)
	{
		long id = ReviewId;
		Review reviewTemp = reviewRepository.findById(id).get();
		reviewTemp.setReview(Review.getReview());
		return reviewRepository.save(reviewTemp);
	}

	// Delete operation
	@Override
	public void deleteReviewById(long ReviewId)
	{
		long id = ReviewId;
		reviewRepository.deleteById(id);
	}

	// Read operation
	@Override
	public List<Review> findAllReviewUsersNative(String username) {

		return reviewRepository.findAllReviewUsersNative(username);
	}

	// Read operation
	@Override
	public List<Review> findAllReviewNative(String productId) {
		
		return reviewRepository.findAllReviewNative(productId);
	}

}

