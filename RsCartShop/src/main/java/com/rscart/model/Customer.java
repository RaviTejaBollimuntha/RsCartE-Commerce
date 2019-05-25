package com.rscart.model;

import org.hibernate.validator.constraints.NotEmpty;

import com.rscart.validator.CustomEmail;
import com.rscart.validator.FieldMatch;
import com.rscart.validator.PasswordMatches;
import com.rscart.validator.ValidPassword;

@FieldMatch.List({
    @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")    
})
@PasswordMatches
public class Customer {	
	private Long customerId;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String userName;
	@NotEmpty
	@ValidPassword
	private String password;
	@NotEmpty
	@ValidPassword
	private String confirmPassword;
	@CustomEmail
	@NotEmpty
	private String emailAddress;
	@NotEmpty
	private String phoneNumber;
	private int logStatus;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public int getLogStatus() {
		return logStatus;
	}

	public void setLogStatus(int logStatus) {
		this.logStatus = logStatus;
	}
	
}
