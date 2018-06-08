package com.dosirak.web.dao;

import java.util.List;

import com.dosirak.web.vo.History;
import com.dosirak.web.vo.Record;

public interface HistoryDAO {
	
	public int insertBeforeWorkHistory(String owner, int gold);
	public int insertWorkHistory(String owner, int gold, int pay);
	public String getComeBackHomeTime(String owner, String status);
	
	public int insertBeforeTravelHistory(String owner, int time);
	public List<Integer> getHistoryCode(String owner, String kind);
	public int insertTravelHistory(String owner, String kind, int code);
	public Record getRecordHistory(String owner);
	public int insertTravelFriendHistory(String owner, String fid);
	
}
