package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.Ticket;

public interface TicketDAO {
	public Ticket getTicket(int tCode);		// Ƽ�� �ϳ� ��ȯ
	public List<Ticket> getTicketList();	// ��� Ƽ�� ����Ʈ ��ȯ
	public int takeTicket(String owner);	// Ƽ�� �ϳ� ��
}
