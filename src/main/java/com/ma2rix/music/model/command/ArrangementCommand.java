package com.ma2rix.music.model.command;

import java.io.Serializable;

import org.joda.time.DateTime;

import com.ma2rix.music.common.CommonUtils;

/**
 * 편곡 리스트 및 편곡 세부 정보보기에 사용되는 command 클래스
 */
public class ArrangementCommand implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int arrangeNo;								 /* 편곡번호 */
	private int composeNo;								 /* 작곡번호 */
	private int arrangeMemberNo;						 /* 편곡자회원번호 */
	private String arrangeMemberName;					 /* 편곡자회원명 */
	private String arrangeMemberNickName;				 /* 편곡자회원닉네임 */
	private String composeMemberName; 					 /* 작곡자회원명 */
	private String composeMemberNickName; 				 /* 작곡자회원닉네임 */
	private String arrangeTitle;						 /* 편곡제목 */
	private int genreNo; 								 /* 쟝르번호 */
	private String genreName;							 /* 쟝르명 */
	private String openStatus; 						 /* 보컬공개여부 */
	private float composeRate;							 /* 작곡배분율 */
	private float arrangeRate; 						 /* 편곡배분율 */
	private float vocalRate; 							 /* 보컬배분율 */
	private float lyricsRate; 							 /* 작사 배분율*/
	private String arrangeMemo; 						 /* 편곡 메모 */
	private String composeMemo; 						 /* 작곡 메모 */
	private int limitCount;							 /* 배포제한수 */
	private int vocalCount; 						     /* 보컬수 */
	private int fanCount; 								 /* 팬수 */
	private int lyricsCount; 							 /* 작사수 */
	private int performCount; 							 /* 연주수 */
	private int arrangeHits; 							 /* 조회수 */
	private int arrangeImage; 							 /* 편곡이미지파일 */
	private String arrangeImageWeb = "../resources/images/holderType3.gif"; 					 /* 편곡이미지파일 Web Path */
	private String arrangeImageFile; 					 /* 편곡이미지파일 Local Path */
	private int arrangeScore; 							 /* 악보파일 */
	private String arrangeScoreWeb; 					 /* 악보파일 Web Path */
	private String arrangeScoreFile; 					 /* 악보파일 Local Path */
	private int arrangeSound;							 /* 음원파일 */
	private String arrangeSoundWeb; 					 /* 음원파일 Web Path */
	private String arrangeSoundFile; 					 /* 음원파일 Local Path */
	private String arrangeSoundMp3;					 /* 음원파일 mp3 Path */
	private String arrangeSoundOgg;					 /* 음원파일 ogg Path */
	private String arrangeSoundPng; 					 /* 음원파일 pbg Path */
	private int guideSound; 						 	 /* 가이드음원파일 */
	private String guideSoundWeb; 					     /* 가이드음원파일 Web Path */
	private String guideSoundFile; 					 /* 가이드음원파일 Local Path */
	private String guideSoundMp3; 						 /* 가이드음원파일 mp3 Path */
	private String guideSoundOgg; 						 /* 가이드음원파일 ogg Path */
	private String guideSoundPng; 						 /* 가이드음원파일 pbg Path */

	private int arrangeZip; 							 /* 기타파일 */
	private String arrangeZipWeb;						 /* 기타파일 Web Path */
	private String arrangeZipFile; 					 /* 기타파일 Local Path */

	private float salePrice; 							 /* 판매가격 */
	private String limitStatus;						 /* 배포제한여부 */
	private String chargeStatus;					     /* 유료여부 */
	private String arrangeStatus;						 /* 편곡상태 */
	private String saleStatus; 						 /* 판매상태 */
	private DateTime regDatetime; 						 /* 등록일시 */
	
	public String getRealArrangeImage(){
		if (arrangeImageWeb != null && ! "".equals(arrangeImageWeb) ){
			return this.arrangeImageWeb;
		}else {
			return "../resources/images/holderType3.gif";
		}
	}
	
	public String getRealLimitCount(){
		if (limitCount == 0) {
			return "";
		}else {
			return String.valueOf(limitCount);
		}
	}
	
	public String getPlaySource(){
		String targetSource = "";
		
		if (CommonUtils.isNullOrEmpty(this.getArrangeSoundMp3()) && 
				CommonUtils.isNullOrEmpty(this.getArrangeSoundOgg())){
			targetSource =  "";
		}else {
			targetSource = this.getArrangeSoundMp3()+ ";" + this.getArrangeSoundOgg();
		}
		return targetSource;
	}
	
	public boolean getExistPlaySources(){
		return this.getPlaySource() == "" ? false : true;
	}

	public  ArrangementCommand() {
		super();
	}

	public ArrangementCommand(int arrangeNo, int composeNo,
			int arrangeMemberNo, String arrangeMemberName,
			String arrangeMemberNickName, String composeMemberName,
			String composeMemberNickName, String arrangeTitle, int genreNo,
			String genreName, String openStatus, float composeRate,
			float arrangeRate, float vocalRate, float lyricsRate,
			String arrangeMemo, String composeMemo, int limitCount,
			int vocalCount, int fanCount, int lyricsCount, int performCount,
			int arrangeHits, int arrangeImage, String arrangeImageWeb,
			String arrangeImageFile, int arrangeScore, String arrangeScoreWeb,
			String arrangeScoreFile, int arrangeSound, String arrangeSoundWeb,
			String arrangeSoundFile, String arrangeSoundMp3,
			String arrangeSoundOgg, String arrangeSoundPng, int guideSound,
			String guideSoundWeb, String guideSoundFile, String guideSoundMp3,
			String guideSoundOgg, String guideSoundPng, int arrangeZip,
			String arrangeZipWeb, String arrangeZipFile, float salePrice,
			String limitStatus, String chargeStatus, String arrangeStatus,
			String saleStatus, DateTime regDatetime) {
		super();
		this.arrangeNo = arrangeNo;
		this.composeNo = composeNo;
		this.arrangeMemberNo = arrangeMemberNo;
		this.arrangeMemberName = arrangeMemberName;
		this.arrangeMemberNickName = arrangeMemberNickName;
		this.composeMemberName = composeMemberName;
		this.composeMemberNickName = composeMemberNickName;
		this.arrangeTitle = arrangeTitle;
		this.genreNo = genreNo;
		this.genreName = genreName;
		this.openStatus = openStatus;
		this.composeRate = composeRate;
		this.arrangeRate = arrangeRate;
		this.vocalRate = vocalRate;
		this.lyricsRate = lyricsRate;
		this.arrangeMemo = arrangeMemo;
		this.composeMemo = composeMemo;
		this.limitCount = limitCount;
		this.vocalCount = vocalCount;
		this.fanCount = fanCount;
		this.lyricsCount = lyricsCount;
		this.performCount = performCount;
		this.arrangeHits = arrangeHits;
		this.arrangeImage = arrangeImage;
		this.arrangeImageWeb = arrangeImageWeb;
		this.arrangeImageFile = arrangeImageFile;
		this.arrangeScore = arrangeScore;
		this.arrangeScoreWeb = arrangeScoreWeb;
		this.arrangeScoreFile = arrangeScoreFile;
		this.arrangeSound = arrangeSound;
		this.arrangeSoundWeb = arrangeSoundWeb;
		this.arrangeSoundFile = arrangeSoundFile;
		this.arrangeSoundMp3 = arrangeSoundMp3;
		this.arrangeSoundOgg = arrangeSoundOgg;
		this.arrangeSoundPng = arrangeSoundPng;
		this.guideSound = guideSound;
		this.guideSoundWeb = guideSoundWeb;
		this.guideSoundFile = guideSoundFile;
		this.guideSoundMp3 = guideSoundMp3;
		this.guideSoundOgg = guideSoundOgg;
		this.guideSoundPng = guideSoundPng;
		this.arrangeZip = arrangeZip;
		this.arrangeZipWeb = arrangeZipWeb;
		this.arrangeZipFile = arrangeZipFile;
		this.salePrice = salePrice;
		this.limitStatus = limitStatus;
		this.chargeStatus = chargeStatus;
		this.arrangeStatus = arrangeStatus;
		this.saleStatus = saleStatus;
		this.regDatetime = regDatetime;
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

	public String getArrangeMemberName() {
		return arrangeMemberName;
	}

	public void setArrangeMemberName(String arrangeMemberName) {
		this.arrangeMemberName = arrangeMemberName;
	}

	public String getArrangeMemberNickName() {
		return arrangeMemberNickName;
	}

	public void setArrangeMemberNickName(String arrangeMemberNickName) {
		this.arrangeMemberNickName = arrangeMemberNickName;
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

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
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

	public String getComposeMemo() {
		return composeMemo;
	}

	public void setComposeMemo(String composeMemo) {
		this.composeMemo = composeMemo;
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

	public String getArrangeImageWeb() {
		return arrangeImageWeb;
	}

	public void setArrangeImageWeb(String arrangeImageWeb) {
		this.arrangeImageWeb = arrangeImageWeb;
	}

	public String getArrangeImageFile() {
		return arrangeImageFile;
	}

	public void setArrangeImageFile(String arrangeImageFile) {
		this.arrangeImageFile = arrangeImageFile;
	}

	public int getArrangeScore() {
		return arrangeScore;
	}

	public void setArrangeScore(int arrangeScore) {
		this.arrangeScore = arrangeScore;
	}

	public String getArrangeScoreWeb() {
		return arrangeScoreWeb;
	}

	public void setArrangeScoreWeb(String arrangeScoreWeb) {
		this.arrangeScoreWeb = arrangeScoreWeb;
	}

	public String getArrangeScoreFile() {
		return arrangeScoreFile;
	}

	public void setArrangeScoreFile(String arrangeScoreFile) {
		this.arrangeScoreFile = arrangeScoreFile;
	}

	public int getArrangeSound() {
		return arrangeSound;
	}

	public void setArrangeSound(int arrangeSound) {
		this.arrangeSound = arrangeSound;
	}

	public String getArrangeSoundWeb() {
		return arrangeSoundWeb;
	}

	public void setArrangeSoundWeb(String arrangeSoundWeb) {
		this.arrangeSoundWeb = arrangeSoundWeb;
	}

	public String getArrangeSoundFile() {
		return arrangeSoundFile;
	}

	public void setArrangeSoundFile(String arrangeSoundFile) {
		this.arrangeSoundFile = arrangeSoundFile;
	}

	public String getArrangeSoundMp3() {
		return arrangeSoundMp3;
	}

	public void setArrangeSoundMp3(String arrangeSoundMp3) {
		this.arrangeSoundMp3 = arrangeSoundMp3;
	}

	public String getArrangeSoundOgg() {
		return arrangeSoundOgg;
	}

	public void setArrangeSoundOgg(String arrangeSoundOgg) {
		this.arrangeSoundOgg = arrangeSoundOgg;
	}

	public String getArrangeSoundPng() {
		return arrangeSoundPng;
	}

	public void setArrangeSoundPng(String arrangeSoundPng) {
		this.arrangeSoundPng = arrangeSoundPng;
	}

	public int getGuideSound() {
		return guideSound;
	}

	public void setGuideSound(int guideSound) {
		this.guideSound = guideSound;
	}

	public String getGuideSoundWeb() {
		return guideSoundWeb;
	}

	public void setGuideSoundWeb(String guideSoundWeb) {
		this.guideSoundWeb = guideSoundWeb;
	}

	public String getGuideSoundFile() {
		return guideSoundFile;
	}

	public void setGuideSoundFile(String guideSoundFile) {
		this.guideSoundFile = guideSoundFile;
	}

	public String getGuideSoundMp3() {
		return guideSoundMp3;
	}

	public void setGuideSoundMp3(String guideSoundMp3) {
		this.guideSoundMp3 = guideSoundMp3;
	}

	public String getGuideSoundOgg() {
		return guideSoundOgg;
	}

	public void setGuideSoundOgg(String guideSoundOgg) {
		this.guideSoundOgg = guideSoundOgg;
	}

	public String getGuideSoundPng() {
		return guideSoundPng;
	}

	public void setGuideSoundPng(String guideSoundPng) {
		this.guideSoundPng = guideSoundPng;
	}

	public int getArrangeZip() {
		return arrangeZip;
	}

	public void setArrangeZip(int arrangeZip) {
		this.arrangeZip = arrangeZip;
	}

	public String getArrangeZipWeb() {
		return arrangeZipWeb;
	}

	public void setArrangeZipWeb(String arrangeZipWeb) {
		this.arrangeZipWeb = arrangeZipWeb;
	}

	public String getArrangeZipFile() {
		return arrangeZipFile;
	}

	public void setArrangeZipFile(String arrangeZipFile) {
		this.arrangeZipFile = arrangeZipFile;
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

	public DateTime getRegDatetime() {
		return regDatetime;
	}

	public void setRegDatetime(DateTime regDatetime) {
		this.regDatetime = regDatetime;
	}
	
	

}
