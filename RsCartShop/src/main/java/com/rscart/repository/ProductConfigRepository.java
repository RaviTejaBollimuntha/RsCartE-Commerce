package com.rscart.repository;

import java.util.List;

import com.rscart.model.Product;

public interface ProductConfigRepository {

	public List<Product> readFeaturedProducts();

	public Product readProductById(Long productId);

	public List<Product> readPagenumberProducts(int page_id, int total);

}
