package com.rscart.catalog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rscart.entities.Category;
import com.rscart.entities.Product;
import com.rscart.entities.SubCategory;
import com.rscart.exception.RsCartException;

/**
 * @author Raviteja Bollimuntha
 *
 */
@Service
@Transactional
public class CatalogService {
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	SubCategoryRepository subcategoryRepository;
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getLastestedProducts() {

		return productRepository.findTop5ByOrderByCreatedOnDesc();
	}

	public List<Category> getAllCategories() {

		return categoryRepository.findAll();
	}

	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	public Category getCategoryByName(String name) {
		return categoryRepository.getByName(name);
	}
	public SubCategory getSubCategoryByName(String name) {
		return subcategoryRepository.getByName(name);
	}

	public Category getCategoryById(Integer id) {
		return categoryRepository.findOne(id);
	}
	public SubCategory getSubCategoryById(Integer id) {
		return subcategoryRepository.findOne(id);
	}
	public List<SubCategory> getSubCategoryByCATEGORY_ID(Integer id) {
		return subcategoryRepository.findAllSubCategory(id);
	}

	public Category createCategory(Category category) {
		Category persistedCategory = getCategoryByName(category.getName());
		if (persistedCategory != null) {
			throw new RsCartException("Category " + category.getName() + " already exist");
		}
		return categoryRepository.save(category);
	}
	public SubCategory createSubCategory(SubCategory subcategory) {
		SubCategory persistedSubCategory = getSubCategoryByName(subcategory.getName());
		if (persistedSubCategory != null) {
			throw new RsCartException("SubCategory " + subcategory.getName() + " already exist");
		}
		return subcategoryRepository.save(subcategory);
	}
	public Category updateCategory(Category category) {
		Category persistedCategory = getCategoryById(category.getId());
		if (persistedCategory == null) {
			throw new RsCartException("Category " + category.getId() + " doesn't exist");
		}
		persistedCategory.setDescription(category.getDescription());
		return categoryRepository.save(persistedCategory);
	}
	public SubCategory updateSubCategory(SubCategory subcategory) {
		SubCategory persistedSubCategory = getSubCategoryById(subcategory.getId());
		if (persistedSubCategory == null) {
			throw new RsCartException("subCategory " + subcategory.getId() + " doesn't exist");
		}
		subcategory.setCATEGORY_ID(persistedSubCategory.getCATEGORY_ID());
		return subcategoryRepository.save(subcategory);
	}

	public Product getProductById(Integer id) {
		return productRepository.findOne(id);
	}

	public Product getProductByName(String name) {
		return productRepository.findByName(name);
	}

	public Product createProduct(Product product) {
		Product persistedProduct = getProductByName(product.getName());
		if (persistedProduct != null) {
			throw new RsCartException("Product  " + product.getName() + " already exist");
		}
		return productRepository.save(product);
	}

	public Product updateProduct(Product product) {
		Product persistedProduct = getProductById(product.getId());
		if (persistedProduct == null) {
			throw new RsCartException("Product " + product.getId() + " doesn't exist");
		}
		persistedProduct.setDescription(product.getDescription());
		persistedProduct.setPrice(product.getPrice());
		persistedProduct.setCategory(getCategoryById(product.getCategory().getId()));
		persistedProduct.setFeatured(product.getFeatured());
		persistedProduct.setSubcategory_id(product.getSubcategory_id());
		persistedProduct.setCreatedOn(product.getCreatedOn());
		return productRepository.save(persistedProduct);
	}

	public List<Product> searchProducts(String query) {
		return productRepository.search("%" + query + "%");
	}
}
