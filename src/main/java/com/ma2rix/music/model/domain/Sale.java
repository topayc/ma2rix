package com.ma2rix.music.model.domain;

import org.joda.time.DateTime;

public class Sale {
	private int saleNo;
	private String saleDate;
	private String saleTime;
	private int saleMemberNo;
	private String saleGoods; 
	private int goodsNo;
	private float saleAmount;
	private float saleFee;
	private int cancelSaleNo;
	private String saleStatus;
	private int payNo;
	private int distributeNo;
	private DateTime regDateTime;
	public Sale() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sale(int saleNo, String saleDate, String saleTime, int saleMemberNo,
			String saleGoods, int goodsNo, float saleAmount, float saleFee,
			int cancelSaleNo, String saleStatus, int payNo, int distributeNo,
			DateTime regDateTime) {
		super();
		this.saleNo = saleNo;
		this.saleDate = saleDate;
		this.saleTime = saleTime;
		this.saleMemberNo = saleMemberNo;
		this.saleGoods = saleGoods;
		this.goodsNo = goodsNo;
		this.saleAmount = saleAmount;
		this.saleFee = saleFee;
		this.cancelSaleNo = cancelSaleNo;
		this.saleStatus = saleStatus;
		this.payNo = payNo;
		this.distributeNo = distributeNo;
		this.regDateTime = regDateTime;
	}
	public int getSaleNo() {
		return saleNo;
	}
	public void setSaleNo(int saleNo) {
		this.saleNo = saleNo;
	}
	public String getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	public String getSaleTime() {
		return saleTime;
	}
	public void setSaleTime(String saleTime) {
		this.saleTime = saleTime;
	}
	public int getSaleMemberNo() {
		return saleMemberNo;
	}
	public void setSaleMemberNo(int saleMemberNo) {
		this.saleMemberNo = saleMemberNo;
	}
	public String getSaleGoods() {
		return saleGoods;
	}
	public void setSaleGoods(String saleGoods) {
		this.saleGoods = saleGoods;
	}
	public int getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}
	public float getSaleAmount() {
		return saleAmount;
	}
	public void setSaleAmount(float saleAmount) {
		this.saleAmount = saleAmount;
	}
	public float getSaleFee() {
		return saleFee;
	}
	public void setSaleFee(float saleFee) {
		this.saleFee = saleFee;
	}
	public int getCancelSaleNo() {
		return cancelSaleNo;
	}
	public void setCancelSaleNo(int cancelSaleNo) {
		this.cancelSaleNo = cancelSaleNo;
	}
	public String getSaleStatus() {
		return saleStatus;
	}
	public void setSaleStatus(String saleStatus) {
		this.saleStatus = saleStatus;
	}
	public int getPayNo() {
		return payNo;
	}
	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}
	public int getDistributeNo() {
		return distributeNo;
	}
	public void setDistributeNo(int distributeNo) {
		this.distributeNo = distributeNo;
	}
	public DateTime getRegDateTime() {
		return regDateTime;
	}
	public void setRegDateTime(DateTime regDateTime) {
		this.regDateTime = regDateTime;
	}
	
	
	
}
