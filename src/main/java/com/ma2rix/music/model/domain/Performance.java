package com.ma2rix.music.model.domain;

import org.joda.time.DateTime;

import com.ma2rix.music.manager.AppConstants;

public class Performance {
	
	
	private int performNo;
	private int arrangeNo;
	private int playFieldNo;
	private String playFieldName;
	private int performMemberNo;
	private float performRate;
	private int performSound;
	private String performMemo;
	private String choiceStatus;
	private String confirmStatus;
	private String performStatus;
	private DateTime regDateTime;
	private int modMemberNo;
	private DateTime modDateTime;

	
	public Performance() {}

	public Performance(int performNo, int arrangeNo, int playFieldNo,
			String playFieldName, int performMemberNo, float performRate,
			int performSound, String performMemo, String choiceStatus,
			String confirmStatus, String performStatus, DateTime regDateTime,
			int modMemberNo, DateTime modDateTime) {
		super();
		this.performNo = performNo;
		this.arrangeNo = arrangeNo;
		this.playFieldNo = playFieldNo;
		this.playFieldName = playFieldName;
		this.performMemberNo = performMemberNo;
		this.performRate = performRate;
		this.performSound = performSound;
		this.performMemo = performMemo;
		this.choiceStatus = choiceStatus;
		this.confirmStatus = confirmStatus;
		this.performStatus = performStatus;
		this.regDateTime = regDateTime;
		this.modMemberNo = modMemberNo;
		this.modDateTime = modDateTime;
	}

	public void initPerformance(){
		this.choiceStatus = AppConstants.SelectStatus.NOT_SELECT;
		this.confirmStatus = AppConstants.ConfirmStatus.NOT_CONFIRM;
		this.performStatus = AppConstants.PerformStatus.WAITING_PERFORMER;
	}
	public int getPerformNo() {
		return performNo;
	}

	public void setPerformNo(int performNo) {
		this.performNo = performNo;
	}

	public int getArrangeNo() {
		return arrangeNo;
	}

	public void setArrangeNo(int arrangeNo) {
		this.arrangeNo = arrangeNo;
	}

	public int getPlayFieldNo() {
		return playFieldNo;
	}

	public void setPlayFieldNo(int playFieldNo) {
		this.playFieldNo = playFieldNo;
	}

	public String getPlayFieldName() {
		return playFieldName;
	}

	public void setPlayFieldName(String playFieldName) {
		this.playFieldName = playFieldName;
	}

	public int getPerformMemberNo() {
		return performMemberNo;
	}

	public void setPerformMemberNo(int performMemberNo) {
		this.performMemberNo = performMemberNo;
	}

	public float getPerformRate() {
		return performRate;
	}

	public void setPerformRate(float performRate) {
		this.performRate = performRate;
	}

	public int getPerformSound() {
		return performSound;
	}

	public void setPerformSound(int performSound) {
		this.performSound = performSound;
	}

	public String getPerformMemo() {
		return performMemo;
	}

	public void setPerformMemo(String performMemo) {
		this.performMemo = performMemo;
	}

	public String getChoiceStatus() {
		return choiceStatus;
	}

	public void setChoiceStatus(String choiceStatus) {
		this.choiceStatus = choiceStatus;
	}

	public String getConfirmStatus() {
		return confirmStatus;
	}

	public void setConfirmStatus(String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}

	public String getPerformStatus() {
		return performStatus;
	}

	public void setPerformStatus(String performStatus) {
		this.performStatus = performStatus;
	}

	public DateTime getRegDateTime() {
		return regDateTime;
	}

	public void setRegDateTime(DateTime regDateTime) {
		this.regDateTime = regDateTime;
	}

	public int getModMemberNo() {
		return modMemberNo;
	}

	public void setModMemberNo(int modMemberNo) {
		this.modMemberNo = modMemberNo;
	}

	public DateTime getModDateTime() {
		return modDateTime;
	}

	public void setModDateTime(DateTime modDateTime) {
		this.modDateTime = modDateTime;
	}

    
}
