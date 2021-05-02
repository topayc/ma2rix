package com.ma2rix.music.web.security;

import java.io.Serializable;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ma2rix.music.model.domain.User;

@Component
@Scope("session")
public class LoginInfo  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User currentUser;
	private Date loginTime;

	public LoginInfo() {
		super();
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public LoginInfo(User currentUser, Date loginTime) {
		super();
		this.currentUser = currentUser;
		this.loginTime = loginTime;
	}

	public boolean isLoggedIn() {
		return (this.currentUser != null);
	}
}
