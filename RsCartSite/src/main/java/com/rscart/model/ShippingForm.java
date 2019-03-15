package com.rscart.model;

public class ShippingForm {

	private Long shippingId;
	private String fullName;
	private String address1;
	private String address2;
	private String city;
	private String zipCode;
	private String state;
	private String country;
	private Long Customer_Id;

	public Long getShippingId() {
		return shippingId;
	}

	public void setShippingId(Long shippingId) {
		this.shippingId = shippingId;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = stringConverter(country);
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

	@Override
	public boolean equals(Object o) {

		// If the object is compared with itself then return true
		if (o == this) {
			return true;
		}

		/*
		 * Check if o is an instance of Complex or not "null instanceof [type]" also
		 * returns false
		 */
		if (!(o instanceof ShippingForm)) {
			return false;
		}

		// typecast o to Complex so that we can compare data members
		ShippingForm c = (ShippingForm) o;

		// Compare the data members and return accordingly
		return  fullName.equals( c.fullName)  && address1.equals( c.address1)&& address2.equals( c.address2)&& city.equals( c.city)
				&& zipCode.equals( c.zipCode)&& state.equals( c.state)&& country.equals( c.country);
	}

}
