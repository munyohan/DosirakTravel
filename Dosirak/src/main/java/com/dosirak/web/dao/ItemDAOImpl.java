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

	@Override
	public List<Item> getUserDosirak(String owner) {
		ItemDAO idao = getSqlSession().getMapper(ItemDAO.class);
		return idao.getUserDosirak(owner);
	}

	@Override
	public List<Item> getUserTicket(String owner) {
		ItemDAO idao = getSqlSession().getMapper(ItemDAO.class);
		return idao.getUserTicket(owner);
	}

	@Override
	public List<Item> getUserGift(String owner) {
		ItemDAO idao = getSqlSession().getMapper(ItemDAO.class);
		return idao.getUserGift(owner);
	}
}
