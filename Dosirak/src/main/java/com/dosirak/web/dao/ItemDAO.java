package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.Item;

public interface ItemDAO {
	public List<Item> getItemList();			// 모든 아이템 목록 반환
	public List<Item> getPlayerItemList(String owner);	// 한 유저가 갖고있는 모든 아이템 반환
	public int dropItem(int seq);				// 아이템 하나 버림
}
