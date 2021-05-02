package com.ma2rix.music.model.domain;

import org.joda.time.DateTime;

public class ComposeArranger {
	private int composeNo;
	private int arrangeMemberNo;
	private DateTime regDataTime;
	public ComposeArranger() {
		super();
		// TODO Auto-generated constructor stub
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
	public DateTime getRegDataTime() {
		return regDataTime;
	}
	public void setRegDataTime(DateTime regDataTime) {
		this.regDataTime = regDataTime;
	}
	
	
	
}
