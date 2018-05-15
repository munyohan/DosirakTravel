package com.dosirak.web.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.dosirak.web.vo.Country;

public class CountryDAOImpl extends SqlSessionDaoSupport implements CountryDAO{

	@Override
	public Country getCountry(String country) {
		CountryDAO condao = getSqlSession().getMapper(CountryDAO.class);
		return condao.getCountry(country);
	}

	@Override
	public List<Country> getCountryList() {
		CountryDAO condao = getSqlSession().getMapper(CountryDAO.class);
		return condao.getCountryList();
	}

}
