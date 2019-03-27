package com.rscart.repository;

import java.util.List;

import com.rscart.model.Customer;
import com.rscart.model.ReviewForm;

public interface ReviewRepository {
	void reviewProduct(ReviewForm reviewForm);

	List<ReviewForm> getProductReviews(Long productId);

	List<ReviewForm> getReviewByCustomer(Customer customer);
}
