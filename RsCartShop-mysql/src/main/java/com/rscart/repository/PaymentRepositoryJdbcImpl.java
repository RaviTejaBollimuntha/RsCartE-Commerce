package com.rscart.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.rscart.model.CreditCardForm;
import com.rscart.repository.PaymentRepository;

@Repository
public class PaymentRepositoryJdbcImpl implements PaymentRepository {
	private static final String  WITHDRAW_QUERY="UPDATE RS_TX_ACCOUNT SET BALANCE=BALANCE-? WHERE ACCNO=?";
	private static final String  DEPOSITE_QUERY="UPDATE  RS_TX_ACCOUNT SET BALANCE=BALANCE+? WHERE ACCNO=?";
    private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
	public void setDataSource(DataSource dataSource) {
    	this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
	}

	@Override
	public void payByCreditCard(CreditCardForm creditCardForm) {
		String sql = "insert into payment (CC_Number,CC_Name,CC_CVV,CC_Expiry_Month,CC_Expiry_Year,Customer_Id) values (:creditCardNumber,:name,:cvvCode,:month,:year,:customerId)";
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(
				creditCardForm);
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);
	}
	@Override
	public int withdraw(double accNo, double amt) {
		int  count=0;
		count=jdbcTemplate.update(WITHDRAW_QUERY,amt,accNo);
		return count;
	}

	@Override
	public int deposite(double accNo, double amt) {
		int  count=0;
		count=jdbcTemplate.update(DEPOSITE_QUERY,amt,accNo);
		return count;
	}

}
