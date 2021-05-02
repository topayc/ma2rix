package com.ma2rix.music.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ma2rix.music.model.command.UserUpdateCommand;

public class UserUpdateValidator implements Validator {
	
	private static final String[] ACCEPTED_IMAGE_EXTENSIONS = new String[] {
        "png",
        "jpg", 
    };
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserUpdateCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserUpdateCommand userUpdateCommand = (UserUpdateCommand)target;
		
	}

}
