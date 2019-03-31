package com.rscart.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Raviteja Bollimuntha
 *
 */
@Entity
@Table(name = "review")
public class Reviews implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "Review_ID")
	private Long reviewNumber;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Product product;
	@Column(name = "reviewtext")
	private String rtext;
	@Column(name = "submitteddate")
	private Date createdOn;
	@Column(name = "reviewtitle")
	private String rtitle;
	@Column(name = "rating")
	private String rating;
	public Long getReviewNumber() {
		return reviewNumber;
	}
	public void setReviewNumber(Long reviewNumber) {
		this.reviewNumber = reviewNumber;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getRtext() {
		return rtext;
	}
	public void setRtext(String rtext) {
		this.rtext = rtext;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getRtitle() {
		return rtitle;
	}
	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
 
}
