package com.rscart.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Raviteja Bollimuntha
 *
 */
@Entity
@Table(name="product")
public class Product implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	private Integer id;
	@Column(nullable = false)
	private Integer featured;
	@Column(nullable = false)
	private String name;
	private String description;
	private int available;
	@Column(nullable = false)
	private BigDecimal price = new BigDecimal("0.0");
	private String manufacturer;
	@Temporal(TemporalType.DATE)
	@Column(name = "created_on")
	private Date createdOn = new Date();
	private Integer subcategory_id;
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;

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

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getSubcategory_id() {
		return subcategory_id;
	}

	public void setSubcategory_id(Integer subcategory_id) {
		this.subcategory_id = subcategory_id;
	}

	
}
