package com.ma2rix.music.service.interfaces;

import java.util.ArrayList;

import com.ma2rix.music.model.domain.Country;

public interface CountryService {
	public ArrayList<Country> getAllCountries();
	public Country getCountryByCountryNo(int countryNo);
}
