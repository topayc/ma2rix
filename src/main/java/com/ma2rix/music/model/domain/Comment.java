package com.ma2rix.music.model.domain;

import java.io.Serializable;

import org.joda.time.DateTime;

public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int commentNo;
	private String commentContents;
	private int memberNo;
	private String musicClassNo;
	private int musicNo;
	private DateTime regDateTime;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(int commentNo, String commentContents, int memberNo,
			String musicClassNo, int musicNo, DateTime regDateTime) {
		super();
		this.commentNo = commentNo;
		this.commentContents = commentContents;
		this.memberNo = memberNo;
		this.musicClassNo = musicClassNo;
		this.musicNo = musicNo;
		this.regDateTime = regDateTime;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getCommentContents() {
		return commentContents;
	}
	public void setCommentContents(String commentContents) {
		this.commentContents = commentContents;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMusicClassNo() {
		return musicClassNo;
	}
	public void setMusicClassNo(String musicClassNo) {
		this.musicClassNo = musicClassNo;
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
