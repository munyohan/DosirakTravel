package com.dosirak.web.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.dosirak.web.vo.GuestNote;

public class GuestNoteDAOImpl extends SqlSessionDaoSupport implements GuestNoteDAO{

	@Override
	public List<GuestNote> getGuestNoteList(String host) {
		GuestNoteDAO gndao = getSqlSession().getMapper(GuestNoteDAO.class);
		return gndao.getGuestNoteList(host);
	}

	@Override
	public int addGuestNote(String host, String visitor) {
		GuestNoteDAO gndao = getSqlSession().getMapper(GuestNoteDAO.class);
		return gndao.addGuestNote(host, visitor);
	}
}
