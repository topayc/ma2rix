package com.ma2rix.music.model.domain;

import java.io.Serializable;

import org.joda.time.DateTime;

public class Message implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int messageNo;
	private int originMessageNo;
	private int memberNo;
	private int talkMemberNo;
	private String transferType;
	private String messageType;
	private int musicNo;
	private String messageContent;
	private String readStatus;
	private DateTime regDateTime;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(int messageNo, int originMessageNo, int memberNo,
			int talkMemberNo, String transferType, String messageType,
			int musicNo, String messageContent, String readStatus,
			DateTime regDateTime) {
		super();
		this.messageNo = messageNo;
		this.originMessageNo = originMessageNo;
		this.memberNo = memberNo;
		this.talkMemberNo = talkMemberNo;
		this.transferType = transferType;
		this.messageType = messageType;
		this.musicNo = musicNo;
		this.messageContent = messageContent;
		this.readStatus = readStatus;
		this.regDateTime = regDateTime;
	}
	public int getMessageNo() {
		return messageNo;
	}
	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}
	public int getOriginMessageNo() {
		return originMessageNo;
	}
	public void setOriginMessageNo(int originMessageNo) {
		this.originMessageNo = originMessageNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getTalkMemberNo() {
		return talkMemberNo;
	}
	public void setTalkMemberNo(int talkMemberNo) {
		this.talkMemberNo = talkMemberNo;
	}
	public String getTransferType() {
		return transferType;
	}
	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public int getMusicNo() {
		return musicNo;
	}
	public void setMusicNo(int musicNo) {
		this.musicNo = musicNo;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public String getReadStatus() {
		return readStatus;
	}
	public void setReadStatus(String readStatus) {
		this.readStatus = readStatus;
	}
	public DateTime getRegDateTime() {
		return regDateTime;
	}
	public void setRegDateTime(DateTime regDateTime) {
		this.regDateTime = regDateTime;
	}

}
