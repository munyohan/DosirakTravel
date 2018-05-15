package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.City;

public interface CityDAO {
	public City getCity(String city);		// 특정 도시를 반환하는 함수
	public List<City> getCountryCityList(String myCountry);		// 한 국가에 속한 도시들의 리스트를 반환
	public List<City> getCityList();		// 모든 도시 리스트를 반환하는 함수
}
