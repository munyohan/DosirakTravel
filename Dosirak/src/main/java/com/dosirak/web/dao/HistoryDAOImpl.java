package com.dosirak.web.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.dosirak.web.vo.History;
import com.dosirak.web.vo.Player;
import com.dosirak.web.vo.Record;

public class HistoryDAOImpl extends SqlSessionDaoSupport implements HistoryDAO{
	
	@Override
	public int insertBeforeWorkHistory(String owner, int gold) {
		HistoryDAO hdao = getSqlSession().getMapper(HistoryDAO.class);
		return hdao.insertBeforeWorkHistory(owner, gold);
	}

	@Override
	public int insertWorkHistory(String owner, int gold, int pay) {
		HistoryDAO hdao = getSqlSession().getMapper(HistoryDAO.class);
		return hdao.insertWorkHistory(owner, gold, pay);
	}

	@Override
	public String getComeBackHomeTime(String owner, String status) {
		HistoryDAO hdao = getSqlSession().getMapper(HistoryDAO.class);
		return hdao.getComeBackHomeTime(owner, status);
	}

	@Override
	public int insertBeforeTravelHistory(String owner, int time) {
		HistoryDAO hdao = getSqlSession().getMapper(HistoryDAO.class);
		return hdao.insertBeforeTravelHistory(owner, time);
	}

	@Override
	public List<Integer> getHistoryCode(String owner, String kind) {
		HistoryDAO hdao = getSqlSession().getMapper(HistoryDAO.class);
		return hdao.getHistoryCode(owner, kind);
	}

	@Override
	public int insertTravelHistory(String owner, String kind, int code) {
		HistoryDAO hdao = getSqlSession().getMapper(HistoryDAO.class);
		return hdao.insertTravelHistory(owner, kind, code);
	}

	@Override
	public Record getRecordHistory(String owner) {
		HistoryDAO hdao = getSqlSession().getMapper(HistoryDAO.class);
		return hdao.getRecordHistory(owner);
	}

	@Override
	public int insertTravelFriendHistory(String owner, String fid) {
		HistoryDAO hdao = getSqlSession().getMapper(HistoryDAO.class);
		return hdao.insertTravelFriendHistory(owner, fid);
	}

}
