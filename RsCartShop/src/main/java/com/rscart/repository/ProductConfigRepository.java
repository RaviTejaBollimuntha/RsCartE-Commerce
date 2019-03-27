package com.rscart.repository;

import java.util.List;

import com.rscart.model.Product;

public interface ProductConfigRepository {

	List<Product> readFeaturedProducts();

	Product readProductById(Long productId);

}
