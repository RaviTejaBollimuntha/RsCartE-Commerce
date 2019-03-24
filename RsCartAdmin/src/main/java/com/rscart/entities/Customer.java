package com.rscart.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Raviteja Bollimuntha
 *
 */
@Entity
@Table(name="customer")
public class Customer implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Cust_SEQ")
    @SequenceGenerator(sequenceName = "customer_id_seq", allocationSize = 1, name = "Cust_SEQ")
	@Column(name="Customer_Id")
	private Integer id;
	@Column(name="First_Name", nullable=false)
	@NotEmpty
	private String firstName;
	@Column(name="Last_Name")
	private String lastName;
	@NotEmpty
	@Email
	@Column(name="Email_Address", nullable=false, unique=true)
	private String email;
	@NotEmpty
	@Column(name="User_Name", nullable=false)
	private String User_Name;
	@Column(name="Phone_Number")
	private String phone;
	@Column(name="active")
	private String Active;
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	public String getActive() {
		return Active;
	}
	public void setActive(String active) {
		Active = active;
	}
	
	
}
