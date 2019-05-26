package com.rscart.repository;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CouponRepositoryImpl implements CouponRepository {
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	@Override
	public boolean checkCoupon(String couponvalue) {
		String sql="SELECT COUNT(*) FROM COUPONS WHERE COUPONVALUE=:id";
		Map<String,Object> params=null;
		params=new HashMap<>();
		params.put("id",couponvalue);
		int count=namedParameterJdbcTemplate.queryForObject(sql,params,Integer.class);
		if(count==0)
		return false;
		else
		return true;
	}

}
