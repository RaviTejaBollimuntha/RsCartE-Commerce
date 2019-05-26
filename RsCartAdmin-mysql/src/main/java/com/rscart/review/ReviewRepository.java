package com.rscart.review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rscart.entities.Reviews;

/**
 * @author Raviteja Bollimuntha
 *
 */
public interface ReviewRepository extends JpaRepository<Reviews, Integer>
{
	List<Reviews> findTop5ByOrderByCreatedOnDesc();
}
