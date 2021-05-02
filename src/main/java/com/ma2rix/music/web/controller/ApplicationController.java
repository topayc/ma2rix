package com.ma2rix.music.web.controller;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ma2rix.music.i18n.LocaleManager;
import com.ma2rix.music.i18n.MessageBundle;
import com.ma2rix.music.manager.AppConstants;
import com.ma2rix.music.manager.ForwardingMessageType;
import com.ma2rix.music.model.domain.User;
import com.ma2rix.music.model.dto.ForwardingMessage;
import com.ma2rix.music.web.security.LoginInfo;

/**
 * 각 컨트롤러의 슈퍼 클래스로  
 * 각 컨트롤러 클래스의 공통 로직을 처리
 * 
 * @author v
 *
 */
public class ApplicationController {
	
	@Inject protected Provider<LoginInfo> loginInfoProvider;
	
	/**
	 * 세션의 유저의 이름을 반환
	 * @return
	 */
	@ModelAttribute("userName")
	protected String prepareUser(){
		User user  = currentUser();
		String userName;
		if (user == null){userName = "";
		}else {userName = user.getMemberName();}
		return userName;
	}
	
	/**
	 * 세션의 유저 객체를 모델로 반환.
	 * @return
	 */
	@ModelAttribute("userSession")
	protected String userSession(){
		User user  = currentUser();
		String userSession;
		if (user == null){userSession = AppConstants.Session.USER_SESSION_OUT;
		}else {userSession = AppConstants.Session.USER_SESSION_IN;}
		return userSession;
	}
	
	/**
	 * 현재 로그인한 유저 객체를 반환 
	 * @return
	 */
	protected User currentUser(){
		LoginInfo loginInfo = loginInfoProvider.get();
		return loginInfo.getCurrentUser();
	}
	
	/**
	 * 어떤 요청에 대한 결과 메시지(성공, 실패등) 를 작성함 
	 * @param type
	 * @return
	 */
	protected ForwardingMessage prepareForwardingMessage(ForwardingMessageType type){
		ForwardingMessage message = new ForwardingMessage();
		message.setMessageType(type.messageType());
		message.setMainMessage(type.mainMessageCode());
		message.setSubMessage(type.subMessageCode());
		return message;
	}
	
	/**
	 * 위의 메서드와 동일하나, redirect url 도 같이 설정함
	 * @param type
	 * @param url
	 * @return
	 */
	protected ForwardingMessage prepareForwardingMessage(ForwardingMessageType type,String url){
		ForwardingMessage message = new ForwardingMessage();
		message.setMessageType(type.messageType());
		message.setMainMessage(type.mainMessageCode());
		message.setSubMessage(type.subMessageCode());
		message.setLink(url);
		return message;
	}
	
	/**
	 * 헤더의 레퍼러를 이용해서 직접 접근을 막는다
	 * (레퍼러가 널인 경우, 혹은 레러퍼의 도메인과 사이트의 도메인이 다를 경우 판단)
	 * @param request
	 * @return
	 */
	protected boolean checkReferer(HttpServletRequest request){
		return true;
	}
	
	protected void setLocal(ModelMap model, HttpServletRequest req){
		model.addAttribute("locale", LocaleManager.getLocale(req).getLanguage());
	}
	
	/**
	 * 현래 로케일에 맞는 메시지가 설정된 ForwardingMessage 객체 반환
	 * @param type
	 * @param request
	 * @return
	 */
	protected ForwardingMessage prepareForwardingMessage(ForwardingMessageType type,
			HttpServletRequest request,Object...arguments){
		ForwardingMessage message = new ForwardingMessage();
		message.setMainMessage(MessageBundle.getMessage(type.mainMessageCode(), request));
		message.setMessageType(type.messageType());
		if (arguments != null ){
			message.setSubMessage(MessageBundle.getMessage(type.subMessageCode(), arguments,request));
		}else {
			message.setSubMessage(MessageBundle.getMessage(type.subMessageCode(), request));
		}
		return message;
	}
	
}
