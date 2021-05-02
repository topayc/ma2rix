package com.ma2rix.music.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma2rix.music.dao.interfaces.CountryDao;
import com.ma2rix.music.model.domain.Country;
import com.ma2rix.music.service.interfaces.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired 
	private CountryDao countryDao;

	@Override
	public ArrayList<Country> getAllCountries() {
		return countryDao.getAllCountries();
	}

	@Override
	public Country getCountryByCountryNo(int countryNo) {
		return countryDao.getCountryByCountryNo(countryNo);
	}
	


}
