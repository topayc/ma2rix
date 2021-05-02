package com.ma2rix.music.model.command;

public class MailSendRequest {
	public static final int SEND_ID_MAIL = 1;
	public  static final int SEND_PASS_MAIL = 2;
	public static final int SEND_AUTH_MAIL = 3;
	
	private int type;
	private String email;
	public MailSendRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MailSendRequest(int type, String email) {
		super();
		this.type = type;
		this.email = email;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
