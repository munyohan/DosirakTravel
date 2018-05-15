package com.dosirak.web.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.dosirak.web.vo.Ticket;

public class TicketDAOImpl extends SqlSessionDaoSupport implements TicketDAO{

	@Override
	public Ticket getTicket(int tCode) {
		TicketDAO tdao = getSqlSession().getMapper(TicketDAO.class);
		return tdao.getTicket(tCode);
	}

	@Override
	public List<Ticket> getTicketList() {
		TicketDAO tdao = getSqlSession().getMapper(TicketDAO.class);
		return tdao.getTicketList();
	}

	@Override
	public int takeTicket(String owner) {
		TicketDAO tdao = getSqlSession().getMapper(TicketDAO.class);
		return tdao.takeTicket(owner);
	}
}
