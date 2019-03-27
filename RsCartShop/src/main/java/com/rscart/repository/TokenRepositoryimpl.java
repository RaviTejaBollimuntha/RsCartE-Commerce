package com.rscart.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.rscart.model.Customer;
import com.rscart.util.CustomerMapper;
import com.rscart.util.EmailResetToken;
import com.rscart.util.VerificationToken;
@Repository
public class TokenRepositoryimpl implements TokenRepository {
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	   @Autowired
		public void setDataSource(DataSource dataSource) {
			this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
					dataSource);
		}
	   @Override
		public boolean updatecustomerActive(Long Id) {
			String sql = "UPDATE customer c SET c.active=1 where c.Customer_Id=:customerId";
			SqlParameterSource namedParameters = new MapSqlParameterSource();			
			((MapSqlParameterSource) namedParameters).addValue("customerId",Id);
			int result = namedParameterJdbcTemplate.update(sql, namedParameters);
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		}

	@Override
	public VerificationToken findByVerToken(String token) {
		String sql = "SELECT * FROM CustomerActivation c WHERE c.token=:token";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"token", token);
		VerificationToken verificationToken = namedParameterJdbcTemplate.queryForObject(sql,
				sqlParameterSource, (rs,index)->{
					VerificationToken ebo=null;
					//copy ResultSet record to BO
					 ebo=new VerificationToken();					 
					 ebo.setToken(rs.getString(1));
					 ebo.setExpiryDate(rs.getDate(2));
					 ebo.setCustomerid(rs.getLong(3));
					return ebo;		
		}//method
);
		return verificationToken;		
	}	

	@Override
	public int updatePwdWithID(Long customerid,String password) {
		String sql = "UPDATE customer c SET c.Pass=:password where c.Customer_Id=:customerId";
		SqlParameterSource namedParameters = new MapSqlParameterSource();
		((MapSqlParameterSource) namedParameters)
				.addValue("password", password);
		((MapSqlParameterSource) namedParameters).addValue("customerId",
				customerid);
		int result = namedParameterJdbcTemplate.update(sql, namedParameters);		
		return result;
	}

	

	@Override
	public void deleteVerToken(VerificationToken verificationToken) {
		String sql = "DELETE FROM customeractivation WHERE token=:token";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"token", verificationToken.getToken());
        namedParameterJdbcTemplate.update(sql, sqlParameterSource);		
	}

	@Override
	public void saveVCToken(VerificationToken verificationToken) {
		String sql = "INSERT INTO customeractivation (customer_id,expiry_date,token) VALUES(:customerid,:expiryDate,:token)";
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(verificationToken);
        namedParameterJdbcTemplate.update(sql, sqlParameterSource);
		
	}
	@Override
	public Customer findByEmail(String email) {
		String sql = "SELECT * FROM Customer c WHERE c.User_Name=:email or c.Email_Address=:email";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"email", email);
		Customer customer = namedParameterJdbcTemplate.queryForObject(sql,
				sqlParameterSource, new CustomerMapper());
		return customer;
	}
	@Override
	public void saveEmailToken(EmailResetToken resettoken) {
		String sql = "INSERT INTO emailresettoken (customer_id,expiry_date,token,email) VALUES(:customerid,:expiryDate,:token,:email)";
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(resettoken);
        namedParameterJdbcTemplate.update(sql, sqlParameterSource);		
	}
	@Override
	public EmailResetToken findByEmailToken(String token) {
		String sql = "SELECT * FROM emailresettoken c WHERE c.token=:token";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"token", token);
		EmailResetToken resettoken = namedParameterJdbcTemplate.queryForObject(sql,
				sqlParameterSource, (rs,index)->{
					EmailResetToken ebo=null;
					//copy ResultSet record to BO
					 ebo=new EmailResetToken();					 
					 ebo.setToken(rs.getString(1));
					 ebo.setExpiryDate(rs.getDate(2));
					 ebo.setCustomerid(rs.getLong(3));
					 ebo.setEmail(rs.getString(4));
					return ebo;		
		}//method
);
		return resettoken;
	}
	@Override
	public void deleteEmailToken(EmailResetToken emailToken) {
		String sql = "DELETE FROM emailresettoken WHERE token=:token";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
				"token", emailToken.getToken());
        namedParameterJdbcTemplate.update(sql, sqlParameterSource);
		
	}
	@Override
	public int updateNewEmail(String email, Long customerid) {
		String sql = "UPDATE customer c SET c.email_address=:email where c.Customer_Id=:customerId";
		SqlParameterSource namedParameters = new MapSqlParameterSource();
		((MapSqlParameterSource) namedParameters)
				.addValue("email", email);
		((MapSqlParameterSource) namedParameters).addValue("customerId",
				customerid);
		int result = namedParameterJdbcTemplate.update(sql, namedParameters);		
		return result;
		
	}

}
