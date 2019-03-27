package com.rscart.service;

import java.util.List;

import com.rscart.model.Product;

public interface ProductConfigService {
	List<Product> getFeaturedProducts();

	Product getProductById(Long productId);
}
