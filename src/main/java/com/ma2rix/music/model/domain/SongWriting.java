package com.ma2rix.music.model.domain;

import org.joda.time.DateTime;

public class SongWriting {
	private int writeNo;
	private int arrangeNo;
	private int writeMemberNo;
	private String writeTitle;
	private String writeIntent;
	private String writeWords;
	private String languageNo;
	private int vocalCount;
	private int fanCount;
	private int writeHits;
	private String writeStatus;
	private DateTime regDateTime;
	private int modAdminNo;
	private DateTime modDateTime;

	public SongWriting() {
		super();
	}

	public SongWriting(int writeNo, int arrangeNo, int writeMemberNo,
			String writeTitle, String writeIntent, String writeWords,
			String languageNo, int vocalCount, int fanCount, int writeHits,
			String writeStatus, DateTime regDateTime, int modAdminNo,
			DateTime modDateTime) {
		super();
		this.writeNo = writeNo;
		this.arrangeNo = arrangeNo;
		this.writeMemberNo = writeMemberNo;
		this.writeTitle = writeTitle;
		this.writeIntent = writeIntent;
		this.writeWords = writeWords;
		this.languageNo = languageNo;
		this.vocalCount = vocalCount;
		this.fanCount = fanCount;
		this.writeHits = writeHits;
		this.writeStatus = writeStatus;
		this.regDateTime = regDateTime;
		this.modAdminNo = modAdminNo;
		this.modDateTime = modDateTime;
	}

	public int getWriteNo() {
		return writeNo;
	}

	public void setWriteNo(int writeNo) {
		this.writeNo = writeNo;
	}

	public int getArrangeNo() {
		return arrangeNo;
	}

	public void setArrangeNo(int arrangeNo) {
		this.arrangeNo = arrangeNo;
	}

	public int getWriteMemberNo() {
		return writeMemberNo;
	}

	public void setWriteMemberNo(int writeMemberNo) {
		this.writeMemberNo = writeMemberNo;
	}

	public String getWriteTitle() {
		return writeTitle;
	}

	public void setWriteTitle(String writeTitle) {
		this.writeTitle = writeTitle;
	}

	public String getWriteIntent() {
		return writeIntent;
	}

	public void setWriteIntent(String writeIntent) {
		this.writeIntent = writeIntent;
	}

	public String getWriteWords() {
		return writeWords;
	}

	public void setWriteWords(String writeWords) {
		this.writeWords = writeWords;
	}

	public String getLanguageNo() {
		return languageNo;
	}

	public void setLanguageNo(String languageNo) {
		this.languageNo = languageNo;
	}

	public int getVocalCount() {
		return vocalCount;
	}

	public void setVocalCount(int vocalCount) {
		this.vocalCount = vocalCount;
	}

	public int getFanCount() {
		return fanCount;
	}

	public void setFanCount(int fanCount) {
		this.fanCount = fanCount;
	}

	public int getWriteHits() {
		return writeHits;
	}

	public void setWriteHits(int writeHits) {
		this.writeHits = writeHits;
	}

	public String getWriteStatus() {
		return writeStatus;
	}

	public void setWriteStatus(String writeStatus) {
		this.writeStatus = writeStatus;
	}

	public DateTime getRegDateTime() {
		return regDateTime;
	}

	public void setRegDateTime(DateTime regDateTime) {
		this.regDateTime = regDateTime;
	}

	public int getModAdminNo() {
		return modAdminNo;
	}

	public void setModAdminNo(int modAdminNo) {
		this.modAdminNo = modAdminNo;
	}

	public DateTime getModDateTime() {
		return modDateTime;
	}

	public void setModDateTime(DateTime modDateTime) {
		this.modDateTime = modDateTime;
	}
}
