package com.ma2rix.music.model.command;

import java.io.Serializable;

import org.joda.time.DateTime;

public class PerformanceCommand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int performNo;
	private int arrangeNo;
	private int playFieldNo;
	private String playFieldName;
	private int performMemberNo;
	private String performMemberName;
	private String performMemberNickName;
	private float performRate;
	private int performSound;
	private String performSoundWeb;
	private String performSoundFile;
	private String performSoundMp3;
	private String performSoundOgg;
	private String performSoundPng;
	private String arrangeMemo;
	private String choiceStatus;
	private String confirmStatus;
	private String performStatus;
	private DateTime redDateTime;
	
	// 폼에서 넘어온 해당 행에 대하여 어떠한 처리를 해야 하는지의 updateType 
	// 'del : 삭제 , 'update' : 업데이트 , 'init' : 변화없음 (아무 처리를 하지 않음) 
	
	private int updateType;
	
	//폼에서 해당 연주자에게 메시지를 발송했는지 여부 
	//0 : 미 발송 , 1 발송 
	private String isMessageSend;
	
	//폼에서 작성한 메시지 내용, sendMessage 값이 0 일 경우 폼에서 메시지를 보내지 않은 경우이므로 
	//메시지를 발송한다.
	// updateType 이 'update' 인 경우 미리 보낸 것이기 sendMessage 여부에 상관없이 때문에 발송하지 않는다.
	private String messageContent;
	
	private String messageType;

	public PerformanceCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PerformanceCommand(int performNo, int arrangeNo, int playFieldNo,
			String playFieldName, int performMemberNo,
			String performMemberName, String performMemberNickName,
			float performRate, int performSound, String performSoundWeb,
			String performSoundFile, String performSoundMp3,
			String performSoundOgg, String performSoundPng, String arrangeMemo,
			String choiceStatus, String confirmStatus, String performStatus,
			DateTime redDateTime, int updateType, String isMessageSend,
			String messageContent, String messageType) {
		super();
		this.performNo = performNo;
		this.arrangeNo = arrangeNo;
		this.playFieldNo = playFieldNo;
		this.playFieldName = playFieldName;
		this.performMemberNo = performMemberNo;
		this.performMemberName = performMemberName;
		this.performMemberNickName = performMemberNickName;
		this.performRate = performRate;
		this.performSound = performSound;
		this.performSoundWeb = performSoundWeb;
		this.performSoundFile = performSoundFile;
		this.performSoundMp3 = performSoundMp3;
		this.performSoundOgg = performSoundOgg;
		this.performSoundPng = performSoundPng;
		this.arrangeMemo = arrangeMemo;
		this.choiceStatus = choiceStatus;
		this.confirmStatus = confirmStatus;
		this.performStatus = performStatus;
		this.redDateTime = redDateTime;
		this.updateType = updateType;
		this.isMessageSend = isMessageSend;
		this.messageContent = messageContent;
		this.messageType = messageType;
	}

	public int getPerformNo() {
		return performNo;
	}

	public void setPerformNo(int performNo) {
		this.performNo = performNo;
	}

	public int getArrangeNo() {
		return arrangeNo;
	}

	public void setArrangeNo(int arrangeNo) {
		this.arrangeNo = arrangeNo;
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

	public int getPerformMemberNo() {
		return performMemberNo;
	}

	public void setPerformMemberNo(int performMemberNo) {
		this.performMemberNo = performMemberNo;
	}

	public String getPerformMemberName() {
		return performMemberName;
	}

	public void setPerformMemberName(String performMemberName) {
		this.performMemberName = performMemberName;
	}

	public String getPerformMemberNickName() {
		return performMemberNickName;
	}

	public void setPerformMemberNickName(String performMemberNickName) {
		this.performMemberNickName = performMemberNickName;
	}

	public float getPerformRate() {
		return performRate;
	}

	public void setPerformRate(float performRate) {
		this.performRate = performRate;
	}

	public int getPerformSound() {
		return performSound;
	}

	public void setPerformSound(int performSound) {
		this.performSound = performSound;
	}

	public String getPerformSoundWeb() {
		return performSoundWeb;
	}

	public void setPerformSoundWeb(String performSoundWeb) {
		this.performSoundWeb = performSoundWeb;
	}

	public String getPerformSoundFile() {
		return performSoundFile;
	}

	public void setPerformSoundFile(String performSoundFile) {
		this.performSoundFile = performSoundFile;
	}

	public String getPerformSoundMp3() {
		return performSoundMp3;
	}

	public void setPerformSoundMp3(String performSoundMp3) {
		this.performSoundMp3 = performSoundMp3;
	}

	public String getPerformSoundOgg() {
		return performSoundOgg;
	}

	public void setPerformSoundOgg(String performSoundOgg) {
		this.performSoundOgg = performSoundOgg;
	}

	public String getPerformSoundPng() {
		return performSoundPng;
	}

	public void setPerformSoundPng(String performSoundPng) {
		this.performSoundPng = performSoundPng;
	}

	public String getArrangeMemo() {
		return arrangeMemo;
	}

	public void setArrangeMemo(String arrangeMemo) {
		this.arrangeMemo = arrangeMemo;
	}

	public String getChoiceStatus() {
		return choiceStatus;
	}

	public void setChoiceStatus(String choiceStatus) {
		this.choiceStatus = choiceStatus;
	}

	public String getConfirmStatus() {
		return confirmStatus;
	}

	public void setConfirmStatus(String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}

	public String getPerformStatus() {
		return performStatus;
	}

	public void setPerformStatus(String performStatus) {
		this.performStatus = performStatus;
	}

	public DateTime getRedDateTime() {
		return redDateTime;
	}

	public void setRedDateTime(DateTime redDateTime) {
		this.redDateTime = redDateTime;
	}

	public int getUpdateType() {
		return updateType;
	}

	public void setUpdateType(int updateType) {
		this.updateType = updateType;
	}

	public String getIsMessageSend() {
		return isMessageSend;
	}

	public void setIsMessageSend(String isMessageSend) {
		this.isMessageSend = isMessageSend;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	
	
	
}
