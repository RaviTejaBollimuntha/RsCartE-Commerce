package com.rscart.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.rscart.model.AddressForm;
import com.rscart.model.ShippingForm;
import com.rscart.repository.AddressRepository;
import com.rscart.util.AddressMapper;
import com.rscart.util.ShippingMapper;
import com.rscart.util.States;

@Repository
public class AddressRepositoryJdbcImpl implements AddressRepository {
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
	}

	@Override
	public boolean saveAddress(AddressForm address) {
		String sql = "insert into address (Address_Id,Address_1, Address_2,City,Zip,State,FullName,Customer_Id,Country) "
				+ "VALUES(:addressId,:address1,:address2,:city,:zipCode,:state,:fullName,:Customer_Id,:country)";

		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(
				address);
		int value = namedParameterJdbcTemplate.update(sql, sqlParameterSource);
		if(value==1)
			return true;
		else
			return false;
	}

	@Override
	public List<ShippingForm> readAddressById(Long shippingId) {
		
		String sql = "SELECT * FROM SHIPPINGADDRESS a where a.SHIPPING_ID=:addressId";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"addressId", shippingId);
		List<ShippingForm> listBO=null;
		listBO=namedParameterJdbcTemplate.query(sql,sqlParameterSource,(rs)->{
			List<ShippingForm> listStBO=null;
			ShippingForm bo=null;
			listStBO = new ArrayList<>();
			while(rs.next()){
				bo=new ShippingForm();
								
				
				listStBO.add(bo);
			}
			return listStBO;
			
		}
		);
		return listBO;
	}
	@Override
	public AddressForm readPermentAddressByCustomerId(Long customerid) {
		AddressForm address=null;
		String sql = "SELECT * FROM address a where a.Customer_Id=:customerid";		
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"customerid", customerid);
		try {
	        address = namedParameterJdbcTemplate.queryForObject(sql,sqlParameterSource, new AddressMapper());
		} catch (Exception e) {
			return  null;
		}
		
		return address;
	}

	@Override
	public ShippingForm readAddressByCustomerId(Long customerid) {
		ShippingForm address=null;
		String sql = "SELECT * FROM shippingaddress a where a.Customer_Id=:customerid";		
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"customerid", customerid);
		try {
	        address = namedParameterJdbcTemplate.queryForObject(sql,sqlParameterSource, new ShippingMapper());
		} catch (Exception e) {
			return  null;
		}
		
		return address;
	}

	@Override
	public void shippingAddress(ShippingForm shippingAddress) {
		String sql = "insert into shippingaddress (Shipping_Id,Address_1, Address_2,City,Zip,State,FullName,Customer_Id,Country) "
				+ "VALUES(:shippingId,:address1,:address2,:city,:zipCode,:state,:fullName,:Customer_Id,:country)";

		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(
				shippingAddress);
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);
		
	}

	@Override
	public boolean updateAddress(AddressForm address) {
		String sql = "update address set Address_1=:address1,  Address_2=:address2,City=:city,Zip=:zipCode,State=:state,FullName=:fullName,Country=:country "
				+ "Where Customer_Id=:Customer_Id";

		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(
				address);
		int value = namedParameterJdbcTemplate.update(sql, sqlParameterSource);
		if(value==1)
			return true;
		else
			return false;

	}

	@Override
	public void upadateShippingAddress(ShippingForm shippingAddress) {
		String sql = "update shippingaddress set Address_1=:address1,  Address_2=:address2,City=:city,Zip=:zipCode,State=:state,FullName=:fullName,Country=:country "
				+ "Where Customer_Id=:Customer_Id";
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(
				shippingAddress);
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);
	}

	@Override
	public ShippingForm readShippmentAddressById(Long shippingId) {
		String sql = "SELECT * FROM SHIPPINGADDRESS a where a.SHIPPING_ID=:addressId";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"addressId", shippingId);		
		return namedParameterJdbcTemplate.queryForObject(sql,sqlParameterSource, new ShippingMapper());
	}

}