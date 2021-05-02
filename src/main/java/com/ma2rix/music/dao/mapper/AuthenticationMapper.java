package com.ma2rix.music.dao.mapper;

import com.ma2rix.music.model.domain.Authentication;

public interface AuthenticationMapper {
	public Authentication getAuthentication(Authentication authentication);
	public Authentication getAuthenticationByAuthenticateKey(String authenticateKey);
	public Authentication getAuthenticationDuplicate(Authentication authentication);
	public int insertAuthentication(Authentication authentication);
	public void deleteAuthentication(int authenticateNo);
}

