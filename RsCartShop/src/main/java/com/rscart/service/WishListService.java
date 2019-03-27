package com.rscart.service;

import java.util.List;

import com.rscart.model.Customer;
import com.rscart.model.Product;

public interface WishListService {
    boolean addProductToWishList(Long productId,Customer customer);

	List<Product> getProductsInWishList(Customer customer);
	
	boolean checkIfProductAvailableInWishList(Long productId);
	
	void deleteProductFromWishList(Long productId);
}
