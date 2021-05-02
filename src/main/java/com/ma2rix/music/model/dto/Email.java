package com.ma2rix.music.model.dto;

/**
 * 사용자에게 보낼 메일 정보를 담고 있는 클래스 
 * @author v
 *
 */
public class Email {
	private String subject;
    private String content;
    private String regdate;
    private String receiver;
	
    
    public Email() {}

	public Email(String subject, String content, String regdate, String receiver) {
		super();
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
		this.receiver = receiver;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
    
    
}
