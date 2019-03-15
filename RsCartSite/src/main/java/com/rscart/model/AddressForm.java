package com.rscart.model;

public class AddressForm {

	private Long addressId;
	private String fullName;
	private String address1;
	private String address2;
	private String city;
	private String zipCode;
	private String state;
	private String country;
	private Long Customer_Id;
    
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = stringConverter(country);
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = stringConverter(state);
	}

	public Long getCustomer_Id() {
		return Customer_Id;
	}

	public void setCustomer_Id(Long customer_Id) {
		Customer_Id = customer_Id;
	}

	private String stringConverter(String str) {
		String number = "";
		String letter = "";
		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			if (Character.isDigit(a)) {
				number = number + a;

			} else {
				letter = letter + a;

			}
		}
		return letter;
	}
	

}
