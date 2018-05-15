package com.dosirak.web.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.dosirak.web.vo.Player;

public class PlayerDAOImpl extends SqlSessionDaoSupport implements PlayerDAO{

	@Override
	public int addPlayer(Player player) {
		PlayerDAO pldao = getSqlSession().getMapper(PlayerDAO.class);
		return pldao.addPlayer(player);
	}

	@Override
	public Player getPlayer(String mid) {
		PlayerDAO pldao = getSqlSession().getMapper(PlayerDAO.class);
		return pldao.getPlayer(mid);
	}

}
