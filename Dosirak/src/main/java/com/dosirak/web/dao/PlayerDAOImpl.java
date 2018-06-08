package com.dosirak.web.dao;

import java.util.List;

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

	@Override
	public int updateWorkPlayer(String mid) {
		PlayerDAO pldao = getSqlSession().getMapper(PlayerDAO.class);
		return pldao.updateWorkPlayer(mid);
	}

	@Override
	public int updateHomePlayer(String owner, int pay) {
		PlayerDAO pldao = getSqlSession().getMapper(PlayerDAO.class);
		return pldao.updateHomePlayer(owner, pay);
	}

	@Override
	public int updateTravelPlayer(String owner, String loc) {
		PlayerDAO pldao = getSqlSession().getMapper(PlayerDAO.class);
		return pldao.updateTravelPlayer(owner, loc);
	}

	@Override
	public List<Player> getTravelPlayer(String owner, String loc) {
		PlayerDAO pldao = getSqlSession().getMapper(PlayerDAO.class);
		return pldao.getTravelPlayer(owner, loc);
	}

	@Override
	public int updateHomeafterTravelPlayer(String owner) {
		PlayerDAO pldao = getSqlSession().getMapper(PlayerDAO.class);
		return pldao.updateHomeafterTravelPlayer(owner);
	}

}
