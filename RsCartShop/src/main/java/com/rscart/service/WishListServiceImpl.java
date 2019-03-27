package com.rscart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rscart.model.Customer;
import com.rscart.model.Product;
import com.rscart.repository.WishListRepository;
@Service
public class WishListServiceImpl implements WishListService {

	@Autowired
	private WishListRepository wishListRepository;
	@Autowired
	private ProductConfigService productConfigService;

	@Override
	public boolean addProductToWishList(Long productId, Customer customer) {
		Product product = productConfigService.getProductById(productId);
		return wishListRepository.addProductToWishList(product, customer);
		
	}

	@Override
	public List<Product> getProductsInWishList(Customer customer) {
		List<Product> prodcutsInWishList = wishListRepository.readProductsInWishList(customer);
		return prodcutsInWishList;
	}

	@Override
	public boolean checkIfProductAvailableInWishList(Long productId) {
		Product product = productConfigService.getProductById(productId);		
		return wishListRepository.checkIfProductAvailableInWishList(product);
	}
	
	public void deleteProductFromWishList(Long productId) {
		Product product = productConfigService.getProductById(productId);
		wishListRepository.deleteProductFromWishList(product);
	}
	

}
