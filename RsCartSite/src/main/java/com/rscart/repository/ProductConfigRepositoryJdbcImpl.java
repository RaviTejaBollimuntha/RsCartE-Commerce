package com.rscart.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.rscart.model.Product;
import com.rscart.repository.ProductConfigRepository;
import com.rscart.util.ProductMapper;

@Repository
public class ProductConfigRepositoryJdbcImpl implements ProductConfigRepository {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
	}

	@Override
	public List<Product> readFeaturedProducts() {
		int number = 1;
		String sql = "SELECT * FROM product p where p.Featured= :number";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource("number", number);
		List<Product> productsList = namedParameterJdbcTemplate.query(sql,
				sqlParameterSource, new ProductMapper());
		return productsList;
	}

	@Override
	public Product readProductById(Long productId) {
		String sql = "SELECT * FROM product p where p.Product_Id= :productId";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"productId", productId);
		Product product = namedParameterJdbcTemplate.queryForObject(sql,
				sqlParameterSource, new ProductMapper());
		return product;
	}

}
