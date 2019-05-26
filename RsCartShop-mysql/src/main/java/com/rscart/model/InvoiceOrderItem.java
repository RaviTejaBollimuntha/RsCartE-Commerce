package com.rscart.model;

import java.io.Serializable;

public class InvoiceOrderItem implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long orderItemId;
	private Long orderId;
	private Long productId;
	private String NAME;
	private Long PRICE;
	private Long QUANTITY;
	private Long CATEGORY_ID;
	private Long SUBCATEGORY_ID;
	public Long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public Long getPRICE() {
		return PRICE;
	}
	public void setPRICE(Long pRICE) {
		PRICE = pRICE;
	}
	public Long getQUANTITY() {
		return QUANTITY;
	}
	public void setQUANTITY(Long qUANTITY) {
		QUANTITY = qUANTITY;
	}
	public Long getCATEGORY_ID() {
		return CATEGORY_ID;
	}
	public void setCATEGORY_ID(Long cATEGORY_ID) {
		CATEGORY_ID = cATEGORY_ID;
	}
	public Long getSUBCATEGORY_ID() {
		return SUBCATEGORY_ID;
	}
	public void setSUBCATEGORY_ID(Long sUBCATEGORY_ID) {
		SUBCATEGORY_ID = sUBCATEGORY_ID;
	}

}