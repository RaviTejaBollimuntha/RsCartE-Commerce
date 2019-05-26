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
import com.rscart.model.ReviewForm;
import com.rscart.repository.ReviewRepository;
import com.rscart.util.ReviewMapper;

@Repository
public class ReviewRepositoryJdbcImpl implements ReviewRepository {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
	}

	@Override
	public void reviewProduct(ReviewForm reviewForm) {
		String sql = "insert into review(Customer_Id,ReviewText,SubmittedDate,Product_Id,ReviewTitle,Rating) values (:customerId,:reviewText,:date,:productId,:reviewTitle,:rating)";
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(
				reviewForm);
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);
	}

	@Override
	public List<ReviewForm> getProductReviews(Long productId) {
		String sql = "SELECT * FROM review r where r.Product_Id=:productId";
		SqlParameterSource sqlParameterSource1 = new MapSqlParameterSource(
				"productId", productId);
		List<ReviewForm> reviewsList = namedParameterJdbcTemplate.query(sql,
				sqlParameterSource1, new ReviewMapper());
		return reviewsList;
	}

	@Override
	public List<ReviewForm> getReviewByCustomer(Customer customer) {
		String sql = "SELECT * FROM review r where r.Customer_Id=:customerId";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"customerId", customer.getCustomerId());
		List<ReviewForm> reviewsList = namedParameterJdbcTemplate.query(sql,
				sqlParameterSource, new ReviewMapper());
		return reviewsList;
	}

}
