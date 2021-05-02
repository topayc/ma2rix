package com.ma2rix.music.service.interfaces;

import com.ma2rix.music.model.domain.Authentication;
import com.ma2rix.music.model.domain.User;
import com.ma2rix.music.model.dto.Email;

public interface MailService {
	
	public void sendPassMail(User user);
	public void sendAuthenticatingMail(User user);
	public void sendMail(Email email);
	public void sendIdMail(User user);
	public void sendAuthenticateMail(User user);
	
	public Authentication isAuthentication(Authentication authentication);
	public void deleteAuthentication(int authenticateNo);
}
