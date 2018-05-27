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
	
	public int updateCancelDosirak(int dCode, String owner);
	public int updateCancelTicket(int tCode, String owner);
	
	public Item getDamount(String owner, int dCode);
	public Item getTamount(String owner, int tCode);
	
	public int takeItem(String owner, Item i);
	
	public int deleteDosirak(String owner, int dCode);
	public int deleteTicket(String owner, int tCode);
	
	public int updateRegDosirak(int dCode, String owner);
	public int updateRegTicket(int tCode, String owner);
}
