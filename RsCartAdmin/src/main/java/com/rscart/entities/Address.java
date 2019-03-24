package com.rscart.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Raviteja Bollimuntha
 *
 */
@Entity
@Table(name = "shippingaddress")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer SHIPPING_ID;
	private String FULLNAME;
	private String ADDRESS_1;
	private String ADDRESS_2;
	private String city;
	private String state;
	private String zip;
	private String country;
	
	public Integer getSHIPPING_ID() {
		return SHIPPING_ID;
	}
	public void setSHIPPING_ID(Integer sHIPPING_ID) {
		SHIPPING_ID = sHIPPING_ID;
	}
	public String getFULLNAME() {
		return FULLNAME;
	}
	public void setFULLNAME(String fULLNAME) {
		FULLNAME = fULLNAME;
	}
	public String getADDRESS_1() {
		return ADDRESS_1;
	}
	public void setADDRESS_1(String aDDRESS_1) {
		ADDRESS_1 = aDDRESS_1;
	}
	public String getADDRESS_2() {
		return ADDRESS_2;
	}
	public void setADDRESS_2(String aDDRESS_2) {
		ADDRESS_2 = aDDRESS_2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	
}
