package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.Item;

public interface ItemDAO {
	
	public List<Item> getUserDosirak(String owner);
	public List<Item> getUserTicket(String owner);
	public List<Item> getUserGift(String owner);
	
	public List<Item> getItemList();			// ��� ������ ��� ��ȯ
	public List<Item> getPlayerItemList(String owner);	// �� ������ �����ִ� ��� ������ ��ȯ
	public int dropItem(int seq);				// ������ �ϳ� ����
}
