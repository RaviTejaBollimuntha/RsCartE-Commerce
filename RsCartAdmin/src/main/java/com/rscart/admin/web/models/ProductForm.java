package com.rscart.admin.web.models;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.rscart.entities.Category;
import com.rscart.entities.Product;


/**
 * @author RaviTeja Bollimuntha
 *
 */
public class ProductForm 
{
	private Integer id;
	@NotNull
	private Integer featured;
	@NotEmpty
	private String name;
	private String description;
	@NotNull
	@DecimalMin("0.1")
	private BigDecimal price = new BigDecimal("0.0");
	private Integer available;
	private List<MultipartFile> image;
	private String manufacturer;
	@NotNull
	private Integer categoryId;
	private String subcategory;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getFeatured() {
		return featured;
	}


	public void setFeatured(Integer featured) {
		this.featured = featured;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public Integer getAvailable() {
		return available;
	}


	public void setAvailable(Integer available) {
		this.available = available;
	}


	public List<MultipartFile> getImage() {
		return image;
	}


	public void setImage(List<MultipartFile> image) {
		this.image = image;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public Integer getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


	public String getSubcategory() {
		return subcategory;
	}


	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}


	public Product toProduct() {
		Product p = new Product();
		p.setId(id);
		p.setName(name);
		p.setDescription(description);
		p.setManufacturer(manufacturer);
		p.setPrice(price);
		p.setFeatured(featured);
		Category category = new Category();
		category.setId(categoryId);
		p.setCategory(category );
		p.setSubcategory_id(Integer.parseInt(subcategory));
		p.setAvailable(available);
		return p;
	}	

	public static ProductForm fromProduct(Product product) 
	{
		ProductForm p = new ProductForm();
		p.setId(product.getId());
		p.setName(product.getName());
		p.setDescription(product.getDescription());
		p.setAvailable(product.getAvailable());
		p.setSubcategory(Integer.toString(product.getSubcategory_id()));
		p.setPrice(product.getPrice());
		p.setManufacturer(product.getManufacturer());
		p.setCategoryId(product.getCategory().getId());
		p.setFeatured(product.getFeatured());
		return p;
	}
}
