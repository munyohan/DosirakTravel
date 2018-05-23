package com.dosirak.web.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.dosirak.web.vo.Dosirak;

public class DosirakDAOImpl extends SqlSessionDaoSupport implements DosirakDAO {

	@Override
	public Dosirak getDosirak(int dCode) {
		DosirakDAO dodao = getSqlSession().getMapper(DosirakDAO.class);
		return dodao.getDosirak(dCode);
	}

	@Override
	public Dosirak getDosirakimg(String imgName) {
		DosirakDAO dodao = getSqlSession().getMapper(DosirakDAO.class);
		return dodao.getDosirakimg(imgName);
	}
	
	@Override
	public List<Dosirak> getDosirakList() {
		DosirakDAO dodao = getSqlSession().getMapper(DosirakDAO.class);
		return dodao.getDosirakList();
	}

	@Override
	public int takeDosirak(String owner, int dCode) {
		DosirakDAO dodao = getSqlSession().getMapper(DosirakDAO.class);
		return dodao.takeDosirak(owner, dCode);
	}

}
