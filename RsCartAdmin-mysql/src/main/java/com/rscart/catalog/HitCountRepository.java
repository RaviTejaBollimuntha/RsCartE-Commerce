package com.rscart.catalog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rscart.entities.HitCount;

public interface HitCountRepository extends JpaRepository<HitCount, Integer> {
	@Query("select c.count from HitCount c")
	public int getHitCount();
 
}
