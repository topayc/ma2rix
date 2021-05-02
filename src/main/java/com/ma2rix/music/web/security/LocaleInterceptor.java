package com.ma2rix.music.web.security;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.WebUtils;

/**
 * 로케일을 설정하는 인터셉터 
 * 내부적으로 호출됨으로 주석 생략
 *
 */
public class LocaleInterceptor extends HandlerInterceptorAdapter {
	
	public static final String LOCALE_PARAM_NAME ="lang";
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String lang = request.getParameter(LOCALE_PARAM_NAME);
		
		/*
		 * lang 파라미터가 존재한다면 로케일 셀렉트 박스를 통한 요청임 
		 * 이 경우는 사용자가 선택한 로케일로 설정하고, 원래 페이지로 redirect
		 * false 를 반환하여, 핸들러 체인 중지 , 로케일을 설정하고 컨트롤러를 호출해야할 필요가 있다면 true 를 반환
		 * */
		if (lang != null) {
			WebUtils.setSessionAttribute(
				     request, SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, 
				     StringUtils.parseLocaleString(lang));
			
			/*response.sendRedirect(request.getHeader("referer"));*/
			response.sendRedirect(request.getRequestURI());
		
			return false;
		/*
		 * lang 파타메터가 없다면 다른 페이지의 요청임 
		 * 세션에도 로케일이 존재하지 않는다면, 처음 접속한 것이므로, 브라우저의 accept-language 를 통해 로케일을 설정
		 * true 를 반환하며, 다음의 핸들러로 넘김 
		*/
		}else {
			Locale locale = (Locale) WebUtils.getSessionAttribute(request, 
					SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
			if (locale == null){
				Locale  acceptLocale= request.getLocale();
				WebUtils.setSessionAttribute(
					     request, SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, 
						acceptLocale);
				
				/*WebUtils.setSessionAttribute(
					     request, SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, 
					     Locale.ENGLISH);*/
			}
			return true;
		}
	}
}
