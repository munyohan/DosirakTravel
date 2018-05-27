package com.dosirak.web.dao;

import com.dosirak.web.vo.Backpack;

public interface BackpackDAO {

	public Backpack getBackpack(String owner);		// �������� ������ ��ȯ�Ѵ�.
	
	public Backpack getBackpackimg(String owner);
	
	public int updateDosirak(String owner);
	public int updateTicket(String owner);
	
	public int insertBmodal(String owner, int dCode, int tCode);
	public int updateBDmodal(String owner, int dCode);
	public int updateBTmodal(String owner, int tCode);
	
	public int deleteDosirak(String owner, int dCode);

}
