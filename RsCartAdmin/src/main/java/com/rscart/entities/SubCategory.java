package com.rscart.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Raviteja Bollimuntha
 *
 */
@Entity
@Table(name = "subcategory")
public class SubCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SubCate_SEQ")
    @SequenceGenerator(sequenceName = "subcategory_id_seq", allocationSize = 1, name = "SubCate_SEQ")
	@Column(name = "SUBCATEGORY_ID")
	private Integer id;
	@Column(nullable = false, unique = true)
	private Integer CATEGORY_ID;
	@NotEmpty
	private String name;
	@Column(length = 1024)
	private String description;
	/*
	 * @Column(name="disp_order") private Integer displayOrder; private boolean
	 * disabled;
	 */
	@OneToMany(mappedBy = "category")
	private Set<Product> products;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	/*
	 * public Integer getDisplayOrder() { return displayOrder; } public void
	 * setDisplayOrder(Integer displayOrder) { this.displayOrder = displayOrder; }
	 * 
	 * public boolean isDisabled() { return disabled; } public void
	 * setDisabled(boolean disabled) { this.disabled = disabled; }
	 */
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Integer getCATEGORY_ID() {
		return CATEGORY_ID;
	}

	public void setCATEGORY_ID(Integer cATEGORY_ID) {
		CATEGORY_ID = cATEGORY_ID;
	}

}
