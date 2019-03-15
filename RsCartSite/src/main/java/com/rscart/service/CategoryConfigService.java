package com.rscart.service;

import java.util.List;
import java.util.Map;

import com.rscart.model.Category;
import com.rscart.model.Product;
import com.rscart.model.SubCategory;

/**
 * 
 * @author RaviTeja Bollimuntha Configuration Service for Categories in the
 *         application. Method Definitions for retrieving all the root and child
 *         categories.
 */
public interface CategoryConfigService {

	List<Product> getProductsByCategory(String categoryName);

	List<Product> getProductsBySubCategory(String subCategoryName);

	List<Category> getAllCategories();

	List<SubCategory> getAllSubCategories();

	Long getCategoryByProductId(Product product);

	Category getCategoryBySubCategoryId();

	Category getCategoryBySubCategoryName();

	SubCategory getSubCategoryByCategoryId();

	SubCategory getSubCategoryByCategoryName();

	Long getSubCategoryByProductId(Product product);

	List<SubCategory> getAllSubCategoriesByCategoryId(Long long1);

	Map<Category, List<SubCategory>> getCategoriesMap();

}
