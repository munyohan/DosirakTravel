package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.Ticket;

public interface TicketDAO {
	public Ticket getTicket(int tCode);		// 티켓 하나 반환
	public List<Ticket> getTicketList();	// 모든 티켓 리스트 반환
	public int takeTicket(String owner);	// 티켓 하나 줌
}
