package com.rscart.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rscart.util.Cities;
import com.rscart.util.Country;
import com.rscart.util.States;
 @Repository
public class LocationRepositoryImpl implements LocationRepository {
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public List<Country> getCountries() {
		String sql="SELECT ID,NAME FROM COUNTRIES";
		List<Country> listBO=null;
		listBO=jdbcTemplate.query(sql,rs->{
			List<Country> listConBO=null;
			Country bo=null;
			listConBO=new ArrayList<>();
			while(rs.next()){
				bo=new Country();
				bo.setId(rs.getInt(1));
				bo.setName(rs.getString(2));			
				
				listConBO.add(bo);
			}
			return listConBO;
			
		}	
		);
		return listBO;
		
	}

	@Override
	public List<States> getStates(int countryid) {
		String sql="SELECT ID,NAME FROM STATES WHERE COUNTRY_ID=:id";
		List<States> listBO=null;
		Map<String,Object> params=null;
		params=new HashMap<>();
		params.put("id",countryid);
		listBO=namedParameterJdbcTemplate.query(sql,params,(rs)->{
			List<States> listStBO=null;
			States bo=null;
			listStBO = new ArrayList<>();
			while(rs.next()){
				bo=new States();
				bo.setId(rs.getInt(1));
				bo.setName(rs.getString(2));				
				
				listStBO.add(bo);
			}
			return listStBO;
			
		}
		);
		return listBO;
	}

	@Override
	public List<Cities> getCities(int stateid) {
		String sql="SELECT ID,NAME FROM CITIES WHERE STATE_ID=:id";
		List<Cities> listBO=null;
		Map<String,Object> params=null;
		params=new HashMap<>();
		params.put("id",stateid);
		listBO=namedParameterJdbcTemplate.query(sql,params,(rs)->{
			List<Cities> listCtBO=null;
			Cities bo=null;
			listCtBO = new ArrayList<>();
			while(rs.next()){
				bo=new Cities();
				bo.setId(rs.getInt(1));
				bo.setName(rs.getString(2));		
				
				listCtBO.add(bo);
			}
			return listCtBO;
			
		}
		);
		return listBO;
	}

}
