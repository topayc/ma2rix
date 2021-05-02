package com.ma2rix.music.model.dto;

/**
 * 클라이언트의 요청에 대한 일반 응답 메시지 객체 
 * @author v
 *
 */
public  class ForwardingMessage {
	private int messageType;
	private String mainMessage;
	private String subMessage;
	private String link;
	
	public ForwardingMessage(int messageType, String mainMessage,
			String subMessage, String link) {
		super();
		this.messageType = messageType;
		this.mainMessage = mainMessage;
		this.subMessage = subMessage;
		this.link = link;
	}

	public String getLink() {return link;}

	public void setLink(String link) { this.link = link;}
	public ForwardingMessage() { super();}
	
	public int getMessageType() {return messageType;}
	public void setMessageType(int messageType) {this.messageType = messageType;}
	
	public String getMainMessage() {return mainMessage;}
	public void setMainMessage(String mainMessage) {this.mainMessage = mainMessage;}
	
	public String getSubMessage() {return subMessage;}
	public void setSubMessage(String subMessage) {this.subMessage = subMessage;}
}

