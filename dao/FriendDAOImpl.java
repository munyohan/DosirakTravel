package com.dosirak.web.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.dosirak.web.vo.Friend;

public class FriendDAOImpl extends SqlSessionDaoSupport implements FriendDAO{

	@Override
	public Friend getFriend(int fCode) {
		FriendDAO fdao = getSqlSession().getMapper(FriendDAO.class);
		return fdao.getFriend(fCode);
	}

	@Override
	public List<Friend> getPlayerFriendList(String mid) {
		FriendDAO fdao = getSqlSession().getMapper(FriendDAO.class);
		return fdao.getPlayerFriendList(mid);
	}
}