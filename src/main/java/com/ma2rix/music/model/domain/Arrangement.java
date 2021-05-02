package com.ma2rix.music.model.domain;

import java.io.Serializable;

import org.joda.time.DateTime;



public class Arrangement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int arrangeNo;
	private int composeNo;
	private int arrangeMemberNo;
	private String arrangeTitle;
	private int genreNo;
	private String openStatus; 
	private float composeRate;
	private float arrangeRate;
	private float vocalRate;
	private float lyricsRate;
	private String arrangeMemo;
	private int limitCount;
	private int vocalCount;
	private int fanCount;
	private int lyricsCount;
	private int performCount;
	private int arrangeHits;
	private int arrangeImage;
	private int arrangeScore;
	private int arrangeSound;
	private int guideSound;
	private int arrangeZip;
	private float salePrice;
	private String limitStatus;
	private String chargeStatus; 
	private String arrangeStatus;
	private String saleStatus;
	private int regAdminNo;
	private DateTime regDateTime;
	private int modAdminNo;
	private DateTime modDateTime;
	public Arrangement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Arrangement(int arrangeNo, int composeNo, int arrangeMemberNo,
			String arrangeTitle, int genreNo, String openStatus,
			float composeRate, float arrangeRate, float vocalRate,
			float lyricsRate, String arrangeMemo, int limitCount,
			int vocalCount, int fanCount, int lyricsCount, int performCount,
			int arrangeHits, int arrangeImage, int arrangeScore,
			int arrangeSound, int guideSound, int arrangeZip, float salePrice,
			String limitStatus, String chargeStatus, String arrangeStatus,
			String saleStatus, int regAdminNo, DateTime regDateTime,
			int modAdminNo, DateTime modDateTime) {
		super();
		this.arrangeNo = arrangeNo;
		this.composeNo = composeNo;
		this.arrangeMemberNo = arrangeMemberNo;
		this.arrangeTitle = arrangeTitle;
		this.genreNo = genreNo;
		this.openStatus = openStatus;
		this.composeRate = composeRate;
		this.arrangeRate = arrangeRate;
		this.vocalRate = vocalRate;
		this.lyricsRate = lyricsRate;
		this.arrangeMemo = arrangeMemo;
		this.limitCount = limitCount;
		this.vocalCount = vocalCount;
		this.fanCount = fanCount;
		this.lyricsCount = lyricsCount;
		this.performCount = performCount;
		this.arrangeHits = arrangeHits;
		this.arrangeImage = arrangeImage;
		this.arrangeScore = arrangeScore;
		this.arrangeSound = arrangeSound;
		this.guideSound = guideSound;
		this.arrangeZip = arrangeZip;
		this.salePrice = salePrice;
		this.limitStatus = limitStatus;
		this.chargeStatus = chargeStatus;
		this.arrangeStatus = arrangeStatus;
		this.saleStatus = saleStatus;
		this.regAdminNo = regAdminNo;
		this.regDateTime = regDateTime;
		this.modAdminNo = modAdminNo;
		this.modDateTime = modDateTime;
	}
	public int getArrangeNo() {
		return arrangeNo;
	}
	public void setArrangeNo(int arrangeNo) {
		this.arrangeNo = arrangeNo;
	}
	public int getComposeNo() {
		return composeNo;
	}
	public void setComposeNo(int composeNo) {
		this.composeNo = composeNo;
	}
	public int getArrangeMemberNo() {
		return arrangeMemberNo;
	}
	public void setArrangeMemberNo(int arrangeMemberNo) {
		this.arrangeMemberNo = arrangeMemberNo;
	}
	public String getArrangeTitle() {
		return arrangeTitle;
	}
	public void setArrangeTitle(String arrangeTitle) {
		this.arrangeTitle = arrangeTitle;
	}
	public int getGenreNo() {
		return genreNo;
	}
	public void setGenreNo(int genreNo) {
		this.genreNo = genreNo;
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
	public float getArrangeRate() {
		return arrangeRate;
	}
	public void setArrangeRate(float arrangeRate) {
		this.arrangeRate = arrangeRate;
	}
	public float getVocalRate() {
		return vocalRate;
	}
	public void setVocalRate(float vocalRate) {
		this.vocalRate = vocalRate;
	}
	public float getLyricsRate() {
		return lyricsRate;
	}
	public void setLyricsRate(float lyricsRate) {
		this.lyricsRate = lyricsRate;
	}
	public String getArrangeMemo() {
		return arrangeMemo;
	}
	public void setArrangeMemo(String arrangeMemo) {
		this.arrangeMemo = arrangeMemo;
	}
	public int getLimitCount() {
		return limitCount;
	}
	public void setLimitCount(int limitCount) {
		this.limitCount = limitCount;
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
	public int getLyricsCount() {
		return lyricsCount;
	}
	public void setLyricsCount(int lyricsCount) {
		this.lyricsCount = lyricsCount;
	}
	public int getPerformCount() {
		return performCount;
	}
	public void setPerformCount(int performCount) {
		this.performCount = performCount;
	}
	public int getArrangeHits() {
		return arrangeHits;
	}
	public void setArrangeHits(int arrangeHits) {
		this.arrangeHits = arrangeHits;
	}
	public int getArrangeImage() {
		return arrangeImage;
	}
	public void setArrangeImage(int arrangeImage) {
		this.arrangeImage = arrangeImage;
	}
	public int getArrangeScore() {
		return arrangeScore;
	}
	public void setArrangeScore(int arrangeScore) {
		this.arrangeScore = arrangeScore;
	}
	public int getArrangeSound() {
		return arrangeSound;
	}
	public void setArrangeSound(int arrangeSound) {
		this.arrangeSound = arrangeSound;
	}
	public int getGuideSound() {
		return guideSound;
	}
	public void setGuideSound(int guideSound) {
		this.guideSound = guideSound;
	}
	public int getArrangeZip() {
		return arrangeZip;
	}
	public void setArrangeZip(int arrangeZip) {
		this.arrangeZip = arrangeZip;
	}
	public float getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}
	public String getLimitStatus() {
		return limitStatus;
	}
	public void setLimitStatus(String limitStatus) {
		this.limitStatus = limitStatus;
	}
	public String getChargeStatus() {
		return chargeStatus;
	}
	public void setChargeStatus(String chargeStatus) {
		this.chargeStatus = chargeStatus;
	}
	public String getArrangeStatus() {
		return arrangeStatus;
	}
	public void setArrangeStatus(String arrangeStatus) {
		this.arrangeStatus = arrangeStatus;
	}
	public String getSaleStatus() {
		return saleStatus;
	}
	public void setSaleStatus(String saleStatus) {
		this.saleStatus = saleStatus;
	}
	public int getRegAdminNo() {
		return regAdminNo;
	}
	public void setRegAdminNo(int regAdminNo) {
		this.regAdminNo = regAdminNo;
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
	
	public String getRealLimitCount(){
		if (limitCount == 0) {
			return "";
		}else {
			return String.valueOf(limitCount);
		}
	}
}
