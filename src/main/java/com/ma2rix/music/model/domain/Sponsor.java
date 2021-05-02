package com.ma2rix.music.model.domain;

import org.joda.time.DateTime;

public class Sponsor {
	private int sponsorNo;
	private int memberNo;
	private int sponsorMemberNo;
	private int sponsorAmount;
	private DateTime regDateTime;

	public Sponsor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSponsorNo() {
		return sponsorNo;
	}

	public void setSponsorNo(int sponsorNo) {
		this.sponsorNo = sponsorNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getSponsorMemberNo() {
		return sponsorMemberNo;
	}

	public void setSponsorMemberNo(int sponsorMemberNo) {
		this.sponsorMemberNo = sponsorMemberNo;
	}

	public int getSponsorAmount() {
		return sponsorAmount;
	}

	public void setSponsorAmount(int sponsorAmount) {
		this.sponsorAmount = sponsorAmount;
	}

	public DateTime getRegDateTime() {
		return regDateTime;
	}

	public void setRegDateTime(DateTime regDateTime) {
		this.regDateTime = regDateTime;
	}
	
	

	
	
	
}
