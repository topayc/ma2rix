package com.ma2rix.music.model.domain;

import org.joda.time.DateTime;

public class Fan {
	private int fanNo;
	private int fanMemberNo;
	private int musicMemberNo;
	private int musicNo;
	private DateTime regDateTime;
	
	public Fan() {}

	public Fan(int fanNo, int fanMemberNo, int musicMemberNo, int musicNo,
			DateTime regDateTime) {
		super();
		this.fanNo = fanNo;
		this.fanMemberNo = fanMemberNo;
		this.musicMemberNo = musicMemberNo;
		this.musicNo = musicNo;
		this.regDateTime = regDateTime;
	}

	public int getFanNo() {
		return fanNo;
	}

	public void setFanNo(int fanNo) {
		this.fanNo = fanNo;
	}

	public int getFanMemberNo() {
		return fanMemberNo;
	}

	public void setFanMemberNo(int fanMemberNo) {
		this.fanMemberNo = fanMemberNo;
	}

	public int getMusicMemberNo() {
		return musicMemberNo;
	}

	public void setMusicMemberNo(int musicMemberNo) {
		this.musicMemberNo = musicMemberNo;
	}

	public int getMusicNo() {
		return musicNo;
	}

	public void setMusicNo(int musicNo) {
		this.musicNo = musicNo;
	}

	public DateTime getRegDateTime() {
		return regDateTime;
	}

	public void setRegDateTime(DateTime regDateTime) {
		this.regDateTime = regDateTime;
	}


	
	
	
}
