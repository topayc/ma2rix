package com.ma2rix.music.i18n;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

/**
 * 
 * 현재 로케일에 해당하는 일반, 포맷팅한 메시지를 반환하는 클래스 
 * @author Administrator
 *
 */
@Component
public class MessageBundle implements MessageSourceAware{
	
	private static MessageSource messageSource;
	
	@Override
	public  void setMessageSource(MessageSource messageSource) {
		MessageBundle.messageSource = messageSource;
	}
	
	/**
	 * 코드에 맞는 메시지를 반환
	 * @param code      메시지 코드 
	 * @param request
	 * @return
	 */
	public static String getMessage(String code, HttpServletRequest request){
		return MessageBundle.messageSource.getMessage(code, null, LocaleManager.getLocale(request));
	}
	
	/**
	 * 메시지 아규먼트가 삽입된 메시지 반환
	 * @param code		   메시지 코드
	 * @param arguments   대체될 배열
	 * @param request
	 * @return
	 */
	public static String getMessage(String code, Object[] arguments,HttpServletRequest request){
		return MessageBundle.messageSource.getMessage(code, arguments, LocaleManager.getLocale(request));
	}
}
