package com.ma2rix.music.model.command;

import java.io.Serializable;

public class LoginCommand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	private boolean emailCookie;
	private String loginRoute;
	private String fbemail;
	private String fbusername;
	private String fbuserid;
	private String gguserid;
	private String ggusername;

	public LoginCommand() {}

	public LoginCommand(String email, String password, boolean emailCookie, String loginRoute, String fbemail, String fbusername, String fbuserid, String gguserid, String ggusername) {
		super();
		this.email = email;
		this.password = password;
		this.emailCookie = emailCookie;
		this.loginRoute = loginRoute;
		this.fbemail = fbemail;
		this.fbusername = fbusername;
		this.fbuserid = fbuserid;
		this.gguserid = gguserid;
		this.ggusername = ggusername;
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEmailCookie() {
		return emailCookie;
	}

	public void setEmailCookie(boolean emailCookie) {
		this.emailCookie = emailCookie;
	}

	public String getLoginRoute() {
		return loginRoute;
	}

	public void setLoginRoute(String loginRoute) {
		this.loginRoute = loginRoute;
	}

	public String getFbemail() {
		return fbemail;
	}

	public void setFbemail(String fbemail) {
		this.fbemail = fbemail;
	}

	public String getFbusername() {
		return fbusername;
	}

	public void setFbusername(String fbusername) {
		this.fbusername = fbusername;
	}

	public String getFbuserid() {
		return fbuserid;
	}

	public void setFbuserid(String fbuserid) {
		this.fbuserid = fbuserid;
	}

	public String getGgusername() {
		return ggusername;
	}

	public void setGgusername(String ggusername) {
		this.ggusername = ggusername;
	}

	public String getGguserid() {
		return gguserid;
	}

	public void setGguserid(String gguserid) {
		this.gguserid = gguserid;
	}
	

}
