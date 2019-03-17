package com.rscart.catalog;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rscart.entities.Category;
import com.rscart.entities.SubCategory;

/**
 * @author Raviteja Bollimuntha
 *
 */
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer>{
	public SubCategory getByName(String name);
	@Query("select p from SubCategory p where p.CATEGORY_ID like ?1")
	public List<SubCategory> findAllSubCategory(Integer query);
}
