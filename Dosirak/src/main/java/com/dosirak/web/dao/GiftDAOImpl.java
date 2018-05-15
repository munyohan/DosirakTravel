package com.dosirak.web.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.dosirak.web.vo.Gift;

public class GiftDAOImpl extends SqlSessionDaoSupport implements GiftDAO{

	@Override
	public Gift getGift(int gCode) {
		GiftDAO gdao = getSqlSession().getMapper(GiftDAO.class);
		return gdao.getGift(gCode);
	}

	@Override
	public List<Gift> getGiftList() {
		GiftDAO gdao = getSqlSession().getMapper(GiftDAO.class);
		return gdao.getGiftList();
	}

	@Override
	public int takeGift(Gift gift, String owner) {
		GiftDAO gdao = getSqlSession().getMapper(GiftDAO.class);
		return gdao.takeGift(gift, owner);
	}
}