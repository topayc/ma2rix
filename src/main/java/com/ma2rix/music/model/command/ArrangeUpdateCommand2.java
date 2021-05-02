package com.ma2rix.music.model.command;

import java.io.Serializable;


public class ArrangeUpdateCommand2 implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int arrangeNo;            			 /*편곡번호*/
	private int genreNo;						 /*장르번호*/
	private String arrangeMemo;				 /*편곡 메모*/
	private String limitStatus;        		 /*배포 제한 여부*/ 
	private int limitCount;            		 /*배포 수 */
	private float arrangeRate;         		 /*편곡 배분율*/
	private float lyricsRate;          		 /*작사 배분율 */
	private float composeRate;
	
	private int[] performNos;          		 /*폼에서 전송된 performNo 가 0 인 경우 insert , 0 이 아닌 경우 update 함 */
	private int[] performMembers;
	private String[] performMemberNames;
	private int[] performParts;
	private String[] performPartNames;
	private float[] performRates;   
	
	private int[] actionTypes;					 /*해당 연주자 로우의 삭제 및 인서트 여부*/ 
	
	private String openStatus;        			 /*보컬 공개 여부 */
	private int[] vocalMemberNos;
	private String[] vocalMemberNames;
	public ArrangeUpdateCommand2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrangeUpdateCommand2(int arrangeNo, int genreNo,
			String arrangeMemo, String limitStatus, int limitCount,
			float arrangeRate, float lyricsRate, float composeRate,
			int[] performNos, int[] performMembers,
			String[] performMemberNames, int[] performParts,
			String[] performPartNames, float[] performRates, int[] actionTypes,
			String openStatus, int[] vocalMemberNos, String[] vocalMemberNames) {
		super();
		this.arrangeNo = arrangeNo;
		this.genreNo = genreNo;
		this.arrangeMemo = arrangeMemo;
		this.limitStatus = limitStatus;
		this.limitCount = limitCount;
		this.arrangeRate = arrangeRate;
		this.lyricsRate = lyricsRate;
		this.composeRate = composeRate;
		this.performNos = performNos;
		this.performMembers = performMembers;
		this.performMemberNames = performMemberNames;
		this.performParts = performParts;
		this.performPartNames = performPartNames;
		this.performRates = performRates;
		this.actionTypes = actionTypes;
		this.openStatus = openStatus;
		this.vocalMemberNos = vocalMemberNos;
		this.vocalMemberNames = vocalMemberNames;
	}
	public int getArrangeNo() {
		return arrangeNo;
	}
	public void setArrangeNo(int arrangeNo) {
		this.arrangeNo = arrangeNo;
	}
	public int getGenreNo() {
		return genreNo;
	}
	public void setGenreNo(int genreNo) {
		this.genreNo = genreNo;
	}
	public String getArrangeMemo() {
		return arrangeMemo;
	}
	public void setArrangeMemo(String arrangeMemo) {
		this.arrangeMemo = arrangeMemo;
	}
	public String getLimitStatus() {
		return limitStatus;
	}
	public void setLimitStatus(String limitStatus) {
		this.limitStatus = limitStatus;
	}
	public int getLimitCount() {
		return limitCount;
	}
	public void setLimitCount(int limitCount) {
		this.limitCount = limitCount;
	}
	public float getArrangeRate() {
		return arrangeRate;
	}
	public void setArrangeRate(float arrangeRate) {
		this.arrangeRate = arrangeRate;
	}
	public float getLyricsRate() {
		return lyricsRate;
	}
	public void setLyricsRate(float lyricsRate) {
		this.lyricsRate = lyricsRate;
	}
	public float getComposeRate() {
		return composeRate;
	}
	public void setComposeRate(float composeRate) {
		this.composeRate = composeRate;
	}
	public int[] getPerformNos() {
		return performNos;
	}
	public void setPerformNos(int[] performNos) {
		this.performNos = performNos;
	}
	public int[] getPerformMembers() {
		return performMembers;
	}
	public void setPerformMembers(int[] performMembers) {
		this.performMembers = performMembers;
	}
	public String[] getPerformMemberNames() {
		return performMemberNames;
	}
	public void setPerformMemberNames(String[] performMemberNames) {
		this.performMemberNames = performMemberNames;
	}
	public int[] getPerformParts() {
		return performParts;
	}
	public void setPerformParts(int[] performParts) {
		this.performParts = performParts;
	}
	public String[] getPerformPartNames() {
		return performPartNames;
	}
	public void setPerformPartNames(String[] performPartNames) {
		this.performPartNames = performPartNames;
	}
	public float[] getPerformRates() {
		return performRates;
	}
	public void setPerformRates(float[] performRates) {
		this.performRates = performRates;
	}
	public int[] getActionTypes() {
		return actionTypes;
	}
	public void setActionTypes(int[] actionTypes) {
		this.actionTypes = actionTypes;
	}
	public String getOpenStatus() {
		return openStatus;
	}
	public void setOpenStatus(String openStatus) {
		this.openStatus = openStatus;
	}
	public int[] getVocalMemberNos() {
		return vocalMemberNos;
	}
	public void setVocalMemberNos(int[] vocalMemberNos) {
		this.vocalMemberNos = vocalMemberNos;
	}
	public String[] getVocalMemberNames() {
		return vocalMemberNames;
	}
	public void setVocalMemberNames(String[] vocalMemberNames) {
		this.vocalMemberNames = vocalMemberNames;
	}
	
	
}
