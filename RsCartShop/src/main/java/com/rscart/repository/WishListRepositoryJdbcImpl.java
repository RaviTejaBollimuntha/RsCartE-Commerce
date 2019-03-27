package com.rscart.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.rscart.model.Customer;
import com.rscart.model.Product;
import com.rscart.model.WishList;
import com.rscart.repository.WishListRepository;
import com.rscart.util.ProductMapper;
@Repository
public class WishListRepositoryJdbcImpl implements WishListRepository {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
	}

	@Override
	public boolean addProductToWishList(Product product, Customer customer) {
		String sqlSelect = "SELECT COUNT(*) FROM wishlistdetails w where w.Product_Id = :productId";
		SqlParameterSource sqlParameterSource1 = new MapSqlParameterSource(
				"productId", product.getProductId());
		int result = namedParameterJdbcTemplate.queryForObject(sqlSelect,
				sqlParameterSource1,Integer.class);
		if (result == 0) {
			WishList wishList = new WishList();
			wishList.setCustomerId(customer.getCustomerId());
			wishList.setProductId(product.getProductId());
			String sql = "insert into wishlistdetails(Product_Id,Customer_Id) values(:productId,:customerId)";
			SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(
					wishList);
			namedParameterJdbcTemplate.update(sql, sqlParameterSource);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<Product> readProductsInWishList(Customer customer) {
		String sql = "Select * from product p where p.product_Id IN (select w.Product_Id from wishlistdetails w where w.Customer_Id = :customerId)";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"customerId", customer.getCustomerId());
		List<Product> productsList = namedParameterJdbcTemplate.query(sql,
				sqlParameterSource, new ProductMapper());
		return productsList;
	}

	@Override
	public boolean checkIfProductAvailableInWishList(Product product) {
		String sqlSelect = "SELECT COUNT(*) FROM wishlistdetails w where w.Product_Id = :productId";
		SqlParameterSource sqlParameterSource1 = new MapSqlParameterSource(
				"productId", product.getProductId());
		int result = namedParameterJdbcTemplate.queryForObject(sqlSelect,
				sqlParameterSource1,Integer.class);
		if (result == 1) {
			String sql = "DELETE FROM wishlistdetails where Product_Id=:productId";
			SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(
					product);
			namedParameterJdbcTemplate.update(sql, sqlParameterSource);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void deleteProductFromWishList(Product product) {
		String sql = "DELETE FROM wishlistdetails where Product_Id=:productId";
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(
				product);
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);

	}

}