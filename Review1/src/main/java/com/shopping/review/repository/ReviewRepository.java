package com.shopping.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopping.review.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	@Query(value = "SELECT * FROM REVIEW u WHERE u.username = ?1", nativeQuery = true)
	public List<Review> findAllReviewUsersNative(String username);
	
	@Query(value = "SELECT * FROM REVIEW u WHERE u.product_id = ?1", nativeQuery = true)
	public List<Review> findAllReviewNative(String productId);
	
}
