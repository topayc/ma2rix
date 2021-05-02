package com.ma2rix.music.model.domain;

import org.joda.time.DateTime;

public class PlayField implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int playFieldNo;
	private String playFieldName;
	private int regMemberNo;
	private DateTime regDateTime;
	
	public PlayField() {}

	public PlayField(int playFieldNo, String playFieldName, int regMemberNo,
			DateTime regDateTime) {
		super();
		this.playFieldNo = playFieldNo;
		this.playFieldName = playFieldName;
		this.regMemberNo = regMemberNo;
		this.regDateTime = regDateTime;
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

	public int getRegMemberNo() {
		return regMemberNo;
	}

	public void setRegMemberNo(int regMemberNo) {
		this.regMemberNo = regMemberNo;
	}

	public DateTime getRegDateTime() {
		return regDateTime;
	}

	public void setRegDateTime(DateTime regDateTime) {
		this.regDateTime = regDateTime;
	}

	
	
	
}
