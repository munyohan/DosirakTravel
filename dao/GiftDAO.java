package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.Gift;

public interface GiftDAO {
	public Gift getGift(int gCode);				// 명물 한 개 불러오기
	public List<Gift> getGiftList();	// 명물 전체 불러오기
	public int takeGift(Gift gift, String owner);				// 명물 한 개 유저에게 주기
}
