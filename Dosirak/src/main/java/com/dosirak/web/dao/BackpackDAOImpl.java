package com.dosirak.web.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.dosirak.web.vo.Backpack;

public class BackpackDAOImpl extends SqlSessionDaoSupport implements BackpackDAO {

	@Override
	public Backpack getBackpack(String owner) {
		BackpackDAO bdao = getSqlSession().getMapper(BackpackDAO.class);
		return bdao.getBackpack(owner);
	}
}