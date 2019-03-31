package com.rscart.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rscart.common.services.RsCLogger;
import com.rscart.entities.Reviews;

/**
 * @author Raviteja Bollimuntha
 *
 */
@Service
@Transactional
public class ReviewService {
	private static final RsCLogger logger = RsCLogger.getLogger(ReviewService.class);
	@Autowired
	ReviewRepository reviewsRepository;
	public List<Reviews> getLastestedReviews() {
		return reviewsRepository.findTop5ByOrderByCreatedOnDesc();
	}

}
