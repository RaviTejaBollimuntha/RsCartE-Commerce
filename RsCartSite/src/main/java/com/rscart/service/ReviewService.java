package com.rscart.service;

import java.text.ParseException;
import java.util.List;

import com.rscart.model.Customer;
import com.rscart.model.ReviewForm;

public interface ReviewService {
	void reviewProduct(ReviewForm reviewForm) throws ParseException;

	List<ReviewForm> getProductReviews(
			Long productId) throws ParseException;

	List<ReviewForm> getReviewByCustomer(Customer customer);
}
