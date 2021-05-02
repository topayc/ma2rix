package com.ma2rix.music.web.validator;

import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ma2rix.music.model.domain.User;
import com.ma2rix.music.web.security.LoginInfo;

@Component
public class JoinValidator implements Validator {
	
	@Inject 
	private Provider<LoginInfo> loginInfoProvider;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors){
		LoginInfo loginInfo = loginInfoProvider.get();

	}

}
