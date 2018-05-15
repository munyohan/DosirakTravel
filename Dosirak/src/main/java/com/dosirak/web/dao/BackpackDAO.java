package com.dosirak.web.dao;

import com.dosirak.web.vo.Backpack;

public interface BackpackDAO {
	public Backpack getBackpack(String owner);		// 소유주의 백팩을 반환한다.
}
