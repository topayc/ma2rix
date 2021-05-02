package com.ma2rix.music.model.domain;

import org.joda.time.DateTime;

public class PerformPlayer {
	private int performNo;
	private int playerPerformNo;
	
	private float perforRate;
	private String choiceStatus;
	private DateTime regDateTime;
	private DateTime modDateTime;
	public PerformPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PerformPlayer(int performNo, int playerPerformNo, float perforRate,
			String choiceStatus, DateTime regDateTime, DateTime modDateTime) {
		super();
		this.performNo = performNo;
		this.playerPerformNo = playerPerformNo;
		this.perforRate = perforRate;
		this.choiceStatus = choiceStatus;
		this.regDateTime = regDateTime;
		this.modDateTime = modDateTime;
	}
	public int getPerformNo() {
		return performNo;
	}
	public void setPerformNo(int performNo) {
		this.performNo = performNo;
	}
	public int getPlayerPerformNo() {
		return playerPerformNo;
	}
	public void setPlayerPerformNo(int playerPerformNo) {
		this.playerPerformNo = playerPerformNo;
	}
	public float getPerforRate() {
		return perforRate;
	}
	public void setPerforRate(float perforRate) {
		this.perforRate = perforRate;
	}
	public String getChoiceStatus() {
		return choiceStatus;
	}
	public void setChoiceStatus(String choiceStatus) {
		this.choiceStatus = choiceStatus;
	}
	public DateTime getRegDateTime() {
		return regDateTime;
	}
	public void setRegDateTime(DateTime regDateTime) {
		this.regDateTime = regDateTime;
	}
	public DateTime getModDateTime() {
		return modDateTime;
	}
	public void setModDateTime(DateTime modDateTime) {
		this.modDateTime = modDateTime;
	}
}
