package com.ma2rix.music.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ma2rix.music.manager.AppConstants;
import com.ma2rix.music.model.domain.User;
import com.ma2rix.music.service.interfaces.MailService;
import com.ma2rix.music.service.interfaces.UserService;

@Controller
@RequestMapping("/mail")
public class MailController {
	
	@Autowired MailService emailService;
	@Autowired UserService userService;
	
	/**
	 * 인증 메일을 통한 인증 처리 
	 * @param email
	 * @return 뷰
	 */
	@RequestMapping(value ="/emailAuthenticate", method= RequestMethod.GET)
	public String emailAuthenticate(@RequestParam("email") String email){
		User user = userService.findUser(email);
		if (user != null && user.getMemberUserId().equals(email)){
			user.setMemberStatus(AppConstants.UserStatus.CONFIRM_JOIN);
			userService.updateUser(user);
			return "mail/authenticateSuccess";
		}else {
			return "mail/authenticateFail";
		}
		
	}
	
	@RequestMapping(value ="/sendlAuthenticateEmail", method= RequestMethod.GET)
	public String sendAuthenticateMail(@RequestParam("email") String email){
		User user = userService.findUser(email);
		return null;
		
	}
	
}
