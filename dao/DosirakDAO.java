package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.Dosirak;

public interface DosirakDAO {
	public Dosirak getDosirak(int dCode);				// �ڵ忡 �ش��ϴ� ���ö� �� �� ��ȯ
	public List<Dosirak> getDosirakList();				// ��� ���ö� ����Ʈ ��ȯ
	public int takeDosirak(String owner, int dCode);		// �ش� �������� ���ö� ��
}
