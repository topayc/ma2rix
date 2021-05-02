package com.ma2rix.music.model.domain;

import java.io.Serializable;

import org.joda.time.DateTime;

public class MemberField implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int memberNo;
	private String musicField;
	private DateTime regDateTime;
	
	public MemberField(){}

	public MemberField(int memberNo, String musicField, DateTime regDateTime) {
		super();
		this.memberNo = memberNo;
		this.musicField = musicField;
		this.regDateTime = regDateTime;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMusicField() {
		return musicField;
	}

	public void setMusicField(String musicField) {
		this.musicField = musicField;
	}

	public DateTime getRegDateTime() {
		return regDateTime;
	}

	public void setRegDateTime(DateTime regDateTime) {
		this.regDateTime = regDateTime;
	}

}
