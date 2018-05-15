package com.dosirak.web.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.dosirak.web.vo.Item;

public class ItemDAOImpl extends SqlSessionDaoSupport implements ItemDAO{

	@Override
	public List<Item> getItemList() {
		ItemDAO idao = getSqlSession().getMapper(ItemDAO.class);
		return idao.getItemList();
	}

	@Override
	public List<Item> getPlayerItemList(String owner) {
		ItemDAO idao = getSqlSession().getMapper(ItemDAO.class);
		return idao.getPlayerItemList(owner);
	}

	@Override
	public int dropItem(int seq) {
		ItemDAO idao = getSqlSession().getMapper(ItemDAO.class);
		return idao.dropItem(seq);
	}
}
