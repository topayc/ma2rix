package com.ma2rix.music.model.command;

import org.joda.time.DateTime;

public class ArrangeVocalCommand {
	private int arrangeNo;
	private int vocalMemberNo;
	private String vocalMemberName;
	private DateTime regDateTime;
	
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
	
	public ArrangeVocalCommand() {
		super();
	}

	public ArrangeVocalCommand(int arrangeNo, int vocalMemberNo,
			String vocalMemberName, DateTime regDateTime, int updateType,
			String isMessageSend, String messageContent, String messageType) {
		super();
		this.arrangeNo = arrangeNo;
		this.vocalMemberNo = vocalMemberNo;
		this.vocalMemberName = vocalMemberName;
		this.regDateTime = regDateTime;
		this.updateType = updateType;
		this.isMessageSend = isMessageSend;
		this.messageContent = messageContent;
		this.messageType = messageType;
	}

	public int getArrangeNo() {
		return arrangeNo;
	}

	public void setArrangeNo(int arrangeNo) {
		this.arrangeNo = arrangeNo;
	}

	public int getVocalMemberNo() {
		return vocalMemberNo;
	}

	public void setVocalMemberNo(int vocalMemberNo) {
		this.vocalMemberNo = vocalMemberNo;
	}

	public String getVocalMemberName() {
		return vocalMemberName;
	}

	public void setVocalMemberName(String vocalMemberName) {
		this.vocalMemberName = vocalMemberName;
	}

	public DateTime getRegDateTime() {
		return regDateTime;
	}

	public void setRegDateTime(DateTime regDateTime) {
		this.regDateTime = regDateTime;
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
