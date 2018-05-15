package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.Gift;

public interface GiftDAO {
	public Gift getGift(int gCode);				// �� �� �� �ҷ�����
	public List<Gift> getGiftList();	// �� ��ü �ҷ�����
	public int takeGift(Gift gift, String owner);				// �� �� �� �������� �ֱ�
}
