package com.rscart.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.rscart.model.Customer;
import com.rscart.repository.CustomerRepository;
import com.rscart.util.CustomerMapper;

@Repository
public class CustomerRepositoryJdbcImpl implements CustomerRepository {
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
   @Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Customer validateUsers(String userName, String password) {
		try {
			String sql = "select * from customer c where (c.User_Name=:userName or c.Email_Address=:userName) and c.Pass=:password and active=1";
			SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
					.addValue("userName", userName).addValue("password",
							password);
			Customer customer = namedParameterJdbcTemplate.queryForObject(sql,
					sqlParameterSource, new CustomerMapper());
			return customer;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Long registerUser(Customer customer) {
		String sql = "INSERT INTO customer (CUSTOMER_ID,User_Name,Pass,Email_Address,First_Name,Last_Name,Phone_Number) VALUES(customer_id_seq.NEXTVAL,:userName,:password,:emailAddress,:firstName,:lastName,:phoneNumber)";
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(customer);
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);
		String custid = "SELECT Customer_Id FROM Customer c WHERE c.Email_Address=:emailAddress";
		SqlParameterSource mapsqlParameterSource = new MapSqlParameterSource(
				"emailAddress", customer.getEmailAddress());
		return namedParameterJdbcTemplate.queryForObject(custid, mapsqlParameterSource,Long.class);

		
	}
    @Override
    public Integer upadateUser(Customer customer) {
    	String sql = "UPDATE customer SET User_Name=:userName,FIRST_NAME=:firstName,LAST_NAME=:lastName,PHONE_NUMBER=:phoneNumber WHERE CUSTOMER_ID=:customerId";
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(customer);

		return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }
	@Override
	public boolean changePassword(String password, Customer customer) {
		String sql = "UPDATE customer c SET c.Pass=:password where c.Customer_Id=:customerId";
		SqlParameterSource namedParameters = new MapSqlParameterSource();
		((MapSqlParameterSource) namedParameters)
				.addValue("password", password);
		((MapSqlParameterSource) namedParameters).addValue("customerId",
				customer.getCustomerId());
		int result = namedParameterJdbcTemplate.update(sql, namedParameters);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Customer getCustomerById(Long customerId) {
		String sql = "SELECT * FROM Customer c WHERE c.Customer_Id=:customerId";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"customerId", customerId);
		Customer customer = namedParameterJdbcTemplate.queryForObject(sql,
				sqlParameterSource, new CustomerMapper());
		return customer;
	}

	@Override
	public Long getCustomerById(String userName) {
		String sql = "SELECT Customer_Id FROM Customer c WHERE c.User_Name=:userName";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"userName", userName);
		return namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource,Long.class);

	}
	@Override
	public void updateHitCount() {
		String sql = "SELECT hitcount FROM rshitcount";
		int count=jdbcTemplate.queryForObject(sql, Integer.class);
		String update = "UPDATE rshitcount r  SET r.hitcount=:count";
		SqlParameterSource namedParameters = new MapSqlParameterSource();
		((MapSqlParameterSource) namedParameters)
				.addValue("count", count+1);
		namedParameterJdbcTemplate.update(update, namedParameters);
	}

}
