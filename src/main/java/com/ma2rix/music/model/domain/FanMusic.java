package com.ma2rix.music.model.domain;

import org.joda.time.DateTime;

public class FanMusic {
	private int fanMusicNo;
	private int fanMemberNo;
	private String musicClass;
	private int musicNo;
	private DateTime regDateTime;

	public FanMusic() {}

	public FanMusic(int fanMusicNo, int fanMemberNo, String musicClass,
			int musicNo, DateTime regDateTime) {
		super();
		this.fanMusicNo = fanMusicNo;
		this.fanMemberNo = fanMemberNo;
		this.musicClass = musicClass;
		this.musicNo = musicNo;
		this.regDateTime = regDateTime;
	}

	public int getFanMusicNo() {
		return fanMusicNo;
	}

	public void setFanMusicNo(int fanMusicNo) {
		this.fanMusicNo = fanMusicNo;
	}

	public int getFanMemberNo() {
		return fanMemberNo;
	}

	public void setFanMemberNo(int fanMemberNo) {
		this.fanMemberNo = fanMemberNo;
	}

	public String getMusicClass() {
		return musicClass;
	}

	public void setMusicClass(String musicClass) {
		this.musicClass = musicClass;
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
