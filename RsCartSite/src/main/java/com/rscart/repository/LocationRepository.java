package com.rscart.repository;

import java.util.List;

import com.rscart.util.Cities;
import com.rscart.util.Country;
import com.rscart.util.States;

public interface LocationRepository {
	 public List<Country> getCountries(); 
	  public List<States> getStates(int countryid); 
	  public List<Cities> getCities(int stateid); 
}
