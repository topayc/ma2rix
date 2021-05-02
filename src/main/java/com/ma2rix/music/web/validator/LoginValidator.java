package com.ma2rix.music.web.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.ma2rix.music.model.command.LoginCommand;
import com.ma2rix.music.model.domain.User;
import com.ma2rix.music.service.interfaces.UserService;

@Component
public class LoginValidator implements Validator {

	@Autowired UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	/*	LoginCommand loginForm = (LoginCommand) target;
		User user = userService.findUser(loginForm.getEmail());

		if (user == null || !loginForm.getPassword().equals(user.getMemberPwd())) {
			errors.reject("invlaid login", "invalidLogin");
		} else {
			
		}*/
	}
}
