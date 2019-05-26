package com.rscart.catalog;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rscart.entities.Product;

/**
 * @author Raviteja Bollimuntha
 *
 */
public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByName(String name);

	Product findByfeatured(String featured);
	@Query("select p from Product p where p.name like ?1 or p.featured like ?1 or p.description like ?1")
	List<Product> search(String query);
	
	List<Product> findTop5ByOrderByCreatedOnDesc();

}
