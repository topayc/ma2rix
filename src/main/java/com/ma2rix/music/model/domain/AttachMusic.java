package com.ma2rix.music.model.domain;

import java.io.Serializable;

import org.joda.time.DateTime;

public class AttachMusic implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int attachNo;
	private String musicStep;
	private int musicNo;
	private String musicClass;
	private String webPath;
	private String filePath;
	private String fileName;
	private String fileName2;
	private int attachHits;
	private int downloadCount;
	private int regMemberNo;
	private DateTime regDateTime;
		
	public AttachMusic() {
	}

	public AttachMusic(int attachNo, String musicStep, int musicNo,
			String musicClass, String webPath, String filePath,
			String fileName, String fileName2, int attachHits,
			int downloadCount, int regMemberNo, DateTime regDateTime) {
		super();
		this.attachNo = attachNo;
		this.musicStep = musicStep;
		this.musicNo = musicNo;
		this.musicClass = musicClass;
		this.webPath = webPath;
		this.filePath = filePath;
		this.fileName = fileName;
		this.fileName2 = fileName2;
		this.attachHits = attachHits;
		this.downloadCount = downloadCount;
		this.regMemberNo = regMemberNo;
		this.regDateTime = regDateTime;
	}

	public int getAttachNo() {
		return attachNo;
	}

	public void setAttachNo(int attachNo) {
		this.attachNo = attachNo;
	}

	public String getMusicStep() {
		return musicStep;
	}

	public void setMusicStep(String musicStep) {
		this.musicStep = musicStep;
	}

	public int getMusicNo() {
		return musicNo;
	}

	public void setMusicNo(int musicNo) {
		this.musicNo = musicNo;
	}

	public String getMusicClass() {
		return musicClass;
	}

	public void setMusicClass(String musicClass) {
		this.musicClass = musicClass;
	}

	public String getWebPath() {
		return webPath;
	}

	public void setWebPath(String webPath) {
		this.webPath = webPath;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName2() {
		return fileName2;
	}

	public void setFileName2(String fileName2) {
		this.fileName2 = fileName2;
	}

	public int getAttachHits() {
		return attachHits;
	}

	public void setAttachHits(int attachHits) {
		this.attachHits = attachHits;
	}

	public int getDownloadCount() {
		return downloadCount;
	}

	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
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
