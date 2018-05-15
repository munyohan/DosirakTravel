package com.dosirak.web.vo;

public class Ticket {
	private int tCode;
	private String tName;
	private int price;
	private String country;
	private String imgName;
	
	public int gettCode() {
		return tCode;
	}
	public void settCode(int tCode) {
		this.tCode = tCode;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
}
