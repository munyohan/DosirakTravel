package com.dosirak.web.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.dosirak.web.vo.Backpack;

public class BackpackDAOImpl extends SqlSessionDaoSupport implements BackpackDAO {

	@Override
	public Backpack getBackpack(String owner) {
		BackpackDAO bdao = getSqlSession().getMapper(BackpackDAO.class);
		return bdao.getBackpack(owner);
	}

	@Override
	public Backpack getBackpackimg(String owner) {
		BackpackDAO bdao = getSqlSession().getMapper(BackpackDAO.class);
		return bdao.getBackpackimg(owner);
	}

	@Override
	public int updateDosirak(String owner) {
		BackpackDAO bdao = getSqlSession().getMapper(BackpackDAO.class);
		return bdao.updateDosirak(owner);
	}

	@Override
	public int updateTicket(String owner) {
		BackpackDAO bdao = getSqlSession().getMapper(BackpackDAO.class);
		return bdao.updateTicket(owner);
	}

	@Override
	public int insertBmodal(String owner, int dCode, int tCode) {
		BackpackDAO bdao = getSqlSession().getMapper(BackpackDAO.class);
		return bdao.insertBmodal(owner, dCode, tCode);
	}

	@Override
	public int updateBDmodal(String owner, int dCode) {
		BackpackDAO bdao = getSqlSession().getMapper(BackpackDAO.class);
		return bdao.updateBDmodal(owner, dCode);
	}
	
	@Override
	public int updateBTmodal(String owner, int tCode) {
		BackpackDAO bdao = getSqlSession().getMapper(BackpackDAO.class);
		return bdao.updateBTmodal(owner, tCode);
	}
	
	@Override
	public int deleteDosirak(String owner, int dCode) {
		BackpackDAO bdao = getSqlSession().getMapper(BackpackDAO.class);
		return bdao.deleteDosirak(owner, dCode);
	}



	
	
	

}