package com.rscart.admin.web.models;

import java.math.BigDecimal;

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
	@NotEmpty
	private String manufacturer;
	@NotEmpty
	private String name;
	private String description;
	@NotNull
	@DecimalMin("0.1")
	private BigDecimal price = new BigDecimal("0.0");
	private String imageUrl;
	private MultipartFile image;
	private boolean disabled;
	@NotNull
	private Integer categoryId;
	
	
	public Product toProduct() {
		Product p = new Product();
		p.setId(id);
		p.setName(name);
		p.setDescription(description);
		p.setManufacturer(manufacturer);
		p.setPrice(price);
		p.setFeatured(manufacturer);
		Category category = new Category();
		category.setId(categoryId);
		p.setCategory(category );
		//p.setImageUrl(WebUtils.IMAGES_PREFIX+id+".jpg");
		return p;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public static ProductForm fromProduct(Product product)
	{
		ProductForm p = new ProductForm();
		p.setId(product.getId());
		p.setName(product.getName());
		p.setDescription(product.getDescription());
		p.setDisabled(true);
		p.setPrice(product.getPrice());
		p.setManufacturer(product.getManufacturer());
		p.setCategoryId(product.getCategory().getId());
		//p.setImageUrl(WebUtils.IMAGES_PREFIX+product.getId()+".jpg");
		return p;
	}
}
