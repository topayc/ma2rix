package com.ma2rix.music.dao.mapper;

import java.util.ArrayList;

import com.ma2rix.music.model.domain.Country;

public interface CountryMapper {
	public ArrayList<Country> getAllCountries();
	public Country getCountryByCountryNo(int countryNo);

}
