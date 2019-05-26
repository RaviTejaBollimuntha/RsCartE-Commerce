package com.rscart.service;

import java.util.List;

import com.rscart.util.Cities;
import com.rscart.util.Country;
import com.rscart.util.States;

public interface LocationData {
  public List<Country> getCountries(); 
  public List<States> getStates(int countryid); 
  public List<Cities> getCities(int stateid); 
}
