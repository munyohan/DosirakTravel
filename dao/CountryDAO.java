package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.Country;

public interface CountryDAO {
	public Country getCountry(String country);		// Ư�� ���� ��ȯ
	public List<Country> getCountryList();			// ��� ���� ��ȯ
}
