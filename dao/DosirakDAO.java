package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.Dosirak;

public interface DosirakDAO {
	public Dosirak getDosirak(int dCode);				// 코드에 해당하는 도시락 한 개 반환
	public List<Dosirak> getDosirakList();				// 모든 도시락 리스트 반환
	public int takeDosirak(String owner, int dCode);		// 해당 유저에게 도시락 줌
}
