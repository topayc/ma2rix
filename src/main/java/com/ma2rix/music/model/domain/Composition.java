package com.ma2rix.music.model.domain;

import java.io.Serializable;

import org.joda.time.DateTime;

public class Composition  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private int composeNo;
	private int composeMemberNo;
	private String composeTitle;
	private String openStatus;
	private float composeRate;
	private String composeMemo;
	private int arrangeCount;
	private int vocalCount;
	private int fanCount;
	private int composeHits;
	private int composeImage;
	private int composeScore;
	private int composeSound;
	private float salePrice;
	private String chargeStatus;
	private String composeStatus;
	private String saleStatus;
	private DateTime regDateTime;
	private int modAdminNo;
	private DateTime modDateTime;
	public Composition() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Composition(int composeNo, int composeMemberNo, String composeTitle,
			String openStatus, float composeRate, String composeMemo,
			int arrangeCount, int vocalCount, int fanCount, int composeHits,
			int composeImage, int composeScore, int composeSound,
			float salePrice, String chargeStatus, String composeStatus,
			String saleStatus, DateTime regDateTime, int modAdminNo,
			DateTime modDateTime) {
		super();
		this.composeNo = composeNo;
		this.composeMemberNo = composeMemberNo;
		this.composeTitle = composeTitle;
		this.openStatus = openStatus;
		this.composeRate = composeRate;
		this.composeMemo = composeMemo;
		this.arrangeCount = arrangeCount;
		this.vocalCount = vocalCount;
		this.fanCount = fanCount;
		this.composeHits = composeHits;
		this.composeImage = composeImage;
		this.composeScore = composeScore;
		this.composeSound = composeSound;
		this.salePrice = salePrice;
		this.chargeStatus = chargeStatus;
		this.composeStatus = composeStatus;
		this.saleStatus = saleStatus;
		this.regDateTime = regDateTime;
		this.modAdminNo = modAdminNo;
		this.modDateTime = modDateTime;
	}
	public int getComposeNo() {
		return composeNo;
	}
	public void setComposeNo(int composeNo) {
		this.composeNo = composeNo;
	}
	public int getComposeMemberNo() {
		return composeMemberNo;
	}
	public void setComposeMemberNo(int composeMemberNo) {
		this.composeMemberNo = composeMemberNo;
	}
	public String getComposeTitle() {
		return composeTitle;
	}
	public void setComposeTitle(String composeTitle) {
		this.composeTitle = composeTitle;
	}
	public String getOpenStatus() {
		return openStatus;
	}
	public void setOpenStatus(String openStatus) {
		this.openStatus = openStatus;
	}
	public float getComposeRate() {
		return composeRate;
	}
	public void setComposeRate(float composeRate) {
		this.composeRate = composeRate;
	}
	public String getComposeMemo() {
		return composeMemo;
	}
	public void setComposeMemo(String composeMemo) {
		this.composeMemo = composeMemo;
	}
	public int getArrangeCount() {
		return arrangeCount;
	}
	public void setArrangeCount(int arrangeCount) {
		this.arrangeCount = arrangeCount;
	}
	public int getVocalCount() {
		return vocalCount;
	}
	public void setVocalCount(int vocalCount) {
		this.vocalCount = vocalCount;
	}
	public int getFanCount() {
		return fanCount;
	}
	public void setFanCount(int fanCount) {
		this.fanCount = fanCount;
	}
	public int getComposeHits() {
		return composeHits;
	}
	public void setComposeHits(int composeHits) {
		this.composeHits = composeHits;
	}
	public int getComposeImage() {
		return composeImage;
	}
	public void setComposeImage(int composeImage) {
		this.composeImage = composeImage;
	}
	public int getComposeScore() {
		return composeScore;
	}
	public void setComposeScore(int composeScore) {
		this.composeScore = composeScore;
	}
	public int getComposeSound() {
		return composeSound;
	}
	public void setComposeSound(int composeSound) {
		this.composeSound = composeSound;
	}
	public float getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}
	public String getChargeStatus() {
		return chargeStatus;
	}
	public void setChargeStatus(String chargeStatus) {
		this.chargeStatus = chargeStatus;
	}
	public String getComposeStatus() {
		return composeStatus;
	}
	public void setComposeStatus(String composeStatus) {
		this.composeStatus = composeStatus;
	}
	public String getSaleStatus() {
		return saleStatus;
	}
	public void setSaleStatus(String saleStatus) {
		this.saleStatus = saleStatus;
	}
	public DateTime getRegDateTime() {
		return regDateTime;
	}
	public void setRegDateTime(DateTime regDateTime) {
		this.regDateTime = regDateTime;
	}
	public int getModAdminNo() {
		return modAdminNo;
	}
	public void setModAdminNo(int modAdminNo) {
		this.modAdminNo = modAdminNo;
	}
	public DateTime getModDateTime() {
		return modDateTime;
	}
	public void setModDateTime(DateTime modDateTime) {
		this.modDateTime = modDateTime;
	}
	
	
	
}

