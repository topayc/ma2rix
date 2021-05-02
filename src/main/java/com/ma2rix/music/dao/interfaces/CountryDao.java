package com.ma2rix.music.dao.interfaces;

import java.util.ArrayList;

import com.ma2rix.music.model.domain.Country;

public interface CountryDao {
	public ArrayList<Country> getAllCountries();
	public Country getCountryByCountryNo(int countryNo);
}
