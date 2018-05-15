package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.Country;

public interface CountryDAO {
	public Country getCountry(String country);		// 특정 국가 반환
	public List<Country> getCountryList();			// 모든 국가 반환
}
