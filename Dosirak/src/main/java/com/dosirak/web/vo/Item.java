package com.dosirak.web.vo;

public class Item {
	private int seq;
	private int dCode;
	private int mCode;
	private int tCode;
	private int pCode;
	private String itemkind;
	private int amount;
	private String owner;
	private String imgname;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getdCode() {
		return dCode;
	}
	public void setdCode(int dCode) {
		this.dCode = dCode;
	}
	public int getmCode() {
		return mCode;
	}
	public void setmCode(int mCode) {
		this.mCode = mCode;
	}
	public int gettCode() {
		return tCode;
	}
	public void settCode(int tCode) {
		this.tCode = tCode;
	}
	public int getpCode() {
		return pCode;
	}
	public void setpCode(int pCode) {
		this.pCode = pCode;
	}
	public String getItemkind() {
		return itemkind;
	}
	public void setItemkind(String itemkind) {
		this.itemkind = itemkind;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	
}
