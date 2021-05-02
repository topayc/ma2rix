package com.ma2rix.music.model.command;

import java.io.Serializable;

import org.joda.time.DateTime;

import com.ma2rix.music.manager.AppConstants;

public class CompositionCommand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int composeNo;
	private int musicNo;
	private int composeMemberNo;
	private String composeMemberName;
	private String composeMemberNickName;
	private String composeTitle;
	private String openStatus;
	private float composeRate;
	private String composeMemo;
	private int vocalCount;
	private int fanCount;
	private int composeHits;
	private int composeImage;
	private String composeImageWeb;
	private String composeImageFile;
	private int composeScore;
	private String composeScoreWeb;
	private String composeScoreFile;
	private int composeSound;
	private String composeSoundWeb;
	private String composeSoundFile;
	private String composeSoundMp3;
	private String composeSoundOgg;
	private String composeSoundPng;
	private float salePrice;
	private String chargeStatus;
	private String composeStatus;
	private String saleStatus;
	private DateTime regDateTime;
	private int modAdminNo;
	
	public String getRealComposeImage(){
		if (composeImageWeb != null && ! "".equals(composeImageWeb) ){
			System.out.println("=================================== 리얼 이미지 패스 " + composeImageWeb);
			return this.composeImageWeb;
		}else {
			return "../resources/images/holderType3.gif";
		}
	}
		
	public String getOpenStatusString(){
		return openStatus.equals(AppConstants.OpenStatus.OPEN ) ? "공개" : "비공개";
	}
	
	public String getCoverImageWebString(){
		return ("".equals(this.composeImageWeb) || this.composeImageWeb == null) ?
					AppConstants.Ma2Resource.DEFAULT_COMPOSE_COVER_IMAGE : this.composeImageWeb;
	}
	
	public String getFrequencyImageWebString(){
		return ("".equals(this.composeSoundPng) || this.composeSoundPng == null) ?
				AppConstants.Ma2Resource.DEFAULT_FREQUENCY_IMAGE : this.composeSoundPng;
	}
	//음원파일이 있는 경우 세미콜론를 구분자로 합친 문자열을 반환한다.
	public String getSoundPathString(){
		return null;
	}
	
	public CompositionCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompositionCommand(int composeNo, int composeMemberNo,
			String composeMemberName, String composeMemberNickName,
			String composeTitle, String openStatus, float composeRate,
			String composeMemo, int vocalCount, int fanCount, int composeHits,
			int composeImage, String composeImageWeb, String composeImageFile,
			int composeScore, String composeScoreWeb, String composeScoreFile,
			int composeSound, String composeSoundWeb, String composeSoundFile,
			String composeSoundMp3, String composeSoundOgg,
			String composeSoundPng, float salePrice, String chargeStatus,
			String composeStatus, String saleStatus, DateTime regDateTime,
			int modAdminNo) {
		super();
		this.composeNo = composeNo;
		this.composeMemberNo = composeMemberNo;
		this.composeMemberName = composeMemberName;
		this.composeMemberNickName = composeMemberNickName;
		this.composeTitle = composeTitle;
		this.openStatus = openStatus;
		this.composeRate = composeRate;
		this.composeMemo = composeMemo;
		this.vocalCount = vocalCount;
		this.fanCount = fanCount;
		this.composeHits = composeHits;
		this.composeImage = composeImage;
		this.composeImageWeb = composeImageWeb;
		this.composeImageFile = composeImageFile;
		this.composeScore = composeScore;
		this.composeScoreWeb = composeScoreWeb;
		this.composeScoreFile = composeScoreFile;
		this.composeSound = composeSound;
		this.composeSoundWeb = composeSoundWeb;
		this.composeSoundFile = composeSoundFile;
		this.composeSoundMp3 = composeSoundMp3;
		this.composeSoundOgg = composeSoundOgg;
		this.composeSoundPng = composeSoundPng;
		this.salePrice = salePrice;
		this.chargeStatus = chargeStatus;
		this.composeStatus = composeStatus;
		this.saleStatus = saleStatus;
		this.regDateTime = regDateTime;
		this.modAdminNo = modAdminNo;
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

	public String getComposeMemberName() {
		return composeMemberName;
	}

	public void setComposeMemberName(String composeMemberName) {
		this.composeMemberName = composeMemberName;
	}

	public String getComposeMemberNickName() {
		return composeMemberNickName;
	}

	public void setComposeMemberNickName(String composeMemberNickName) {
		this.composeMemberNickName = composeMemberNickName;
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

	public String getComposeImageWeb() {
		return composeImageWeb;
	}

	public void setComposeImageWeb(String composeImageWeb) {
		this.composeImageWeb = composeImageWeb;
	}

	public String getComposeImageFile() {
		return composeImageFile;
	}

	public void setComposeImageFile(String composeImageFile) {
		this.composeImageFile = composeImageFile;
	}

	public int getComposeScore() {
		return composeScore;
	}

	public void setComposeScore(int composeScore) {
		this.composeScore = composeScore;
	}

	public String getComposeScoreWeb() {
		return composeScoreWeb;
	}

	public void setComposeScoreWeb(String composeScoreWeb) {
		this.composeScoreWeb = composeScoreWeb;
	}

	public String getComposeScoreFile() {
		return composeScoreFile;
	}

	public void setComposeScoreFile(String composeScoreFile) {
		this.composeScoreFile = composeScoreFile;
	}

	public int getComposeSound() {
		return composeSound;
	}

	public void setComposeSound(int composeSound) {
		this.composeSound = composeSound;
	}

	public String getComposeSoundWeb() {
		return composeSoundWeb;
	}

	public void setComposeSoundWeb(String composeSoundWeb) {
		this.composeSoundWeb = composeSoundWeb;
	}

	public String getComposeSoundFile() {
		return composeSoundFile;
	}

	public void setComposeSoundFile(String composeSoundFile) {
		this.composeSoundFile = composeSoundFile;
	}

	public String getComposeSoundMp3() {
		return composeSoundMp3;
	}

	public void setComposeSoundMp3(String composeSoundMp3) {
		this.composeSoundMp3 = composeSoundMp3;
	}

	public String getComposeSoundOgg() {
		return composeSoundOgg;
	}

	public void setComposeSoundOgg(String composeSoundOgg) {
		this.composeSoundOgg = composeSoundOgg;
	}

	public String getComposeSoundPng() {
		return composeSoundPng;
	}

	public void setComposeSoundPng(String composeSoundPng) {
		this.composeSoundPng = composeSoundPng;
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

	public int getMusicNo() {
		return musicNo;
	}

	public void setMusicNo(int musicNo) {
		this.musicNo = musicNo;
	}
}