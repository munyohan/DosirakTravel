package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.City;

public interface CityDAO {
	public City getCity(String city);		// Ư�� ���ø� ��ȯ�ϴ� �Լ�
	public List<City> getCountryCityList(String myCountry);		// �� ������ ���� ���õ��� ����Ʈ�� ��ȯ
	public List<City> getCityList();		// ��� ���� ����Ʈ�� ��ȯ�ϴ� �Լ�
}
