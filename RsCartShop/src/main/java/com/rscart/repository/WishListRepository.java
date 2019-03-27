package com.rscart.repository;

import java.util.List;

import com.rscart.model.Customer;
import com.rscart.model.Product;

public interface WishListRepository {

	boolean addProductToWishList(Product product,Customer customer);

	List<Product> readProductsInWishList(Customer customer);

	boolean checkIfProductAvailableInWishList(Product product);
	
	void deleteProductFromWishList(Product product);
}
