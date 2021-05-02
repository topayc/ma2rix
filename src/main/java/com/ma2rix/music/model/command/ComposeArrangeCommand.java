package com.ma2rix.music.model.command;

import org.joda.time.DateTime;

public class ComposeArrangeCommand {
	private int composeNo;
	private int arrangeMemberNo;
	private String arrangeMemberName;
	private DateTime regDataTime;
	
	// 폼에서 넘어온 해당 행에 대하여 어떠한 처리를 해야 하는지의 updateType 
	// 'del : 삭제 , 'update' : 업데이트 , 'init' : 변화없음 (아무 처리를 하지 않음) 
	private int updateType;
	
	
	//폼에서 해당 보컬에게 메세지를 전송했는지 여부 
	//Y : 전송완료 
	//N:  미 전송, 전송 처리
	// updateType 이 'update' 인 경우 미리 보낸 것이기 sendMessage 여부에 상관없이 때문에 발송하지 않는다.
	private String isMessageSend;
	
	// 전송메시지 
	private String messageContent;
	private String messageType;
	public ComposeArrangeCommand() {
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
	public int getUpdateType() {
		return updateType;
	}
	public void setUpdateType(int updateType) {
		this.updateType = updateType;
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
	public String getIsMessageSend() {
		return isMessageSend;
	}
	public void setIsMessageSend(String isMessageSend) {
		this.isMessageSend = isMessageSend;
	}
	public String getArrangeMemberName() {
		return arrangeMemberName;
	}
	public void setArrangeMemberName(String arrangeMemberName) {
		this.arrangeMemberName = arrangeMemberName;
	}

	
}
