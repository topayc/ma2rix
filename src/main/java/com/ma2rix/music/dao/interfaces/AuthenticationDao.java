package com.ma2rix.music.dao.interfaces;

import com.ma2rix.music.model.domain.Authentication;

public interface AuthenticationDao {

	public Authentication getAuthentication(Authentication authentication);
	public Authentication getAuthenticationByAuthenticateKey(String authenticationKey);
	public Authentication getAuthenticationDuplicate(Authentication authentication);
	
	public boolean insertAuthentication(Authentication authentication);
	public void deleteAuthentication(int authenticateNo);
	
}
