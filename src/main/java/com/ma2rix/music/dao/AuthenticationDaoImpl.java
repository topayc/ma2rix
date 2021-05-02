package com.ma2rix.music.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.AuthenticationDao;
import com.ma2rix.music.dao.mapper.AuthenticationMapper;
import com.ma2rix.music.model.domain.Authentication;

@Repository
public class AuthenticationDaoImpl implements AuthenticationDao {


	@Autowired
	private AuthenticationMapper authenticationMapper;
	
	@Override
	public Authentication getAuthentication(Authentication authentication) {
		return authenticationMapper.getAuthentication(authentication);
	}
	
	@Override
	public Authentication getAuthenticationByAuthenticateKey(String authenticationKey) {
		return authenticationMapper.getAuthenticationByAuthenticateKey(authenticationKey);
	}
	
	@Override
	public Authentication getAuthenticationDuplicate(Authentication authentication) {
		return authenticationMapper.getAuthenticationDuplicate(authentication);
	}
	
	@Override
	public boolean insertAuthentication(Authentication authentication) {
		
		int authenticateNo;
		Boolean bDuplicate = false;
		Authentication duplicateAuthentication = authenticationMapper.getAuthentication(authentication);
		
		bDuplicate = (duplicateAuthentication == null ? false : true);
		
		if ( bDuplicate )
		{
			authenticationMapper.deleteAuthentication(duplicateAuthentication.getAuthenticateNo());
		}
		
		authenticateNo = authenticationMapper.insertAuthentication(authentication);
		authentication.setAuthenticateNo(authenticateNo);
		
		return true;
	}

	@Override
	public void deleteAuthentication(int authenticateNo) {
		authenticationMapper.deleteAuthentication(authenticateNo);
	}


}
