package com.rscart.service;

import java.util.List;

import com.rscart.model.Product;

public interface ProductConfigService {
	public List<Product> getFeaturedProducts();

	public Product getProductById(Long productId);

	public List<Product> getPagenumberByProducts(int page_id, int total);

}
