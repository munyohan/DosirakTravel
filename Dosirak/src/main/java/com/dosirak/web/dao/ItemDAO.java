package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.Item;

public interface ItemDAO {
	public List<Item> getItemList();			// ��� ������ ��� ��ȯ
	public List<Item> getPlayerItemList(String owner);	// �� ������ �����ִ� ��� ������ ��ȯ
	public int dropItem(int seq);				// ������ �ϳ� ����
}
