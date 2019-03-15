package com.rscart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rscart.repository.LocationRepository;
import com.rscart.util.Cities;
import com.rscart.util.Country;
import com.rscart.util.States;
@Service
public class LocationDataImpl implements LocationData {
	@Autowired
    private LocationRepository locrepository; 
	@Override
	public List<Country> getCountries() {		
		return locrepository.getCountries();
	}

	@Override
	public List<States> getStates(int countryid) {		
		return locrepository.getStates(countryid);
	}

	@Override
	public List<Cities> getCities(int stateid) {		
		return locrepository.getCities(stateid);
	}

}
