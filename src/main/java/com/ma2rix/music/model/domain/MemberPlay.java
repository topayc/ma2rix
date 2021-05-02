package com.ma2rix.music.model.domain;

import java.io.Serializable;

import org.joda.time.DateTime;


public class MemberPlay implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int memberPlayNo;
	public int memberNo;
	public int playFieldNo;
	public String playFieldName;
	private DateTime regDateTime;
	
	public MemberPlay(){}

	public MemberPlay(int memberPlayNo, int memberNo, int playFieldNo,
			String playFieldName, DateTime regDateTime) {
		super();
		this.memberPlayNo = memberPlayNo;
		this.memberNo = memberNo;
		this.playFieldNo = playFieldNo;
		this.playFieldName = playFieldName;
		this.regDateTime = regDateTime;
	}

	public int getMemberPlayNo() {
		return memberPlayNo;
	}

	public void setMemberPlayNo(int memberPlayNo) {
		this.memberPlayNo = memberPlayNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
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

	public DateTime getRegDateTime() {
		return regDateTime;
	}

	public void setRegDateTime(DateTime regDateTime) {
		this.regDateTime = regDateTime;
	}

}
