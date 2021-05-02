package com.ma2rix.music.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.CountryDao;
import com.ma2rix.music.dao.mapper.CountryMapper;
import com.ma2rix.music.model.domain.Country;

@Repository
public class CountryDaoImpl implements CountryDao {

	
	@Autowired
	private CountryMapper countryMapper; 
	
	@Override
	public ArrayList<Country> getAllCountries() {
		return countryMapper.getAllCountries();
	}

	@Override
	public Country getCountryByCountryNo(int countryNo) {
		return countryMapper.getCountryByCountryNo(countryNo);
	}

}
