package com.rscart.catalog;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rscart.entities.Category;

/**
 * @author Raviteja Bollimuntha
 *
 */
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Category getByName(String name);

}
