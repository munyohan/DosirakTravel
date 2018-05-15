package com.dosirak.web.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.dosirak.web.vo.City;

public class CityDAOImpl extends SqlSessionDaoSupport implements CityDAO{

	@Override
	public City getCity(String city) {
		CityDAO cdao = getSqlSession().getMapper(CityDAO.class);
		return cdao.getCity(city);
	}

	@Override
	public List<City> getCountryCityList(String myCountry) {
		CityDAO cdao = getSqlSession().getMapper(CityDAO.class);
		return cdao.getCountryCityList(myCountry);
	}

	@Override
	public List<City> getCityList() {
		CityDAO cdao = getSqlSession().getMapper(CityDAO.class);
		return cdao.getCityList();
	}
}