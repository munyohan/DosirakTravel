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

	@Override
	public int updateCancelDosirak(int dCode, String owner) {
		ItemDAO idao = getSqlSession().getMapper(ItemDAO.class);
		return idao.updateCancelDosirak(dCode, owner);
	}
	
	@Override
	public int updateCancelTicket(int tCode, String owner) {
		ItemDAO idao = getSqlSession().getMapper(ItemDAO.class);
		return idao.updateCancelTicket(tCode, owner);
	}

	@Override
	public Item getDamount(String owner, int dCode) {
		ItemDAO idao = getSqlSession().getMapper(ItemDAO.class);
		return idao.getDamount(owner, dCode);
	}

	@Override
	public Item getTamount(String owner, int tCode) {
		ItemDAO idao = getSqlSession().getMapper(ItemDAO.class);
		return idao.getTamount(owner, tCode);
	}

	@Override
	public int takeItem(String owner, Item i) {
		ItemDAO idao = getSqlSession().getMapper(ItemDAO.class);
		return idao.takeItem(owner, i);
	}

	@Override
	public int deleteDosirak(String owner, int dCode) {
		ItemDAO idao = getSqlSession().getMapper(ItemDAO.class);
		return idao.deleteDosirak(owner, dCode);
	}
	
	@Override
	public int deleteTicket(String owner, int tCode) {
		ItemDAO idao = getSqlSession().getMapper(ItemDAO.class);
		return idao.deleteTicket(owner, tCode);
	}

	@Override
	public int updateRegDosirak(int dCode, String owner) {
		ItemDAO idao = getSqlSession().getMapper(ItemDAO.class);
		return idao.updateRegDosirak(dCode, owner);
	}

	@Override
	public int updateRegTicket(int tCode, String owner) {
		// TODO Auto-generated method stub
		ItemDAO idao = getSqlSession().getMapper(ItemDAO.class);
		return idao.updateRegTicket(tCode, owner);
	}
	
}
