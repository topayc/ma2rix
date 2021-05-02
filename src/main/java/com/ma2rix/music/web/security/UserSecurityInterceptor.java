package com.ma2rix.music.web.security;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 유저의 로그인 여부를 처리하기 위한 인터셉터 
 * 유저의 로그인 여부 확인이 필요한 url 에 적용함
 * @author v
 *
 */
public class UserSecurityInterceptor extends HandlerInterceptorAdapter {
	
	public static final String[] sessionCheckWhitelist =  new String[]{};
	public static final String[] seesionNoneCheckList = new String[]{};
	
	{
		
	}
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider; 
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		/*워하는 조건을 걸어 처리*/ 
		return true;
		
		/*
		 * user path 접근외에 모든 접근은 세션 여부를 확인해서 허용함
		 * */
		
	/*	String reqUrl = request.getRequestURL().toString(); 
		if (!reqUrl.contains("/user")){
			if (loginInfoProvider.get().isLoggedIn()) {
				return true;
			}
			else {
				response.sendRedirect(request.getContextPath() + "/user/login");
				return false;
			}
		}else {
			return true;
		}*/
		
		/*
		 * 요청이 POST 메서드인 경우 로그인 여부 판단.
		 * POST 액션일 경우 로그인이 안된 상태라면 로그인 페이지로 이동시킴
		 * 차후 필요한 경우 주석 해제
		 * */
		
		/*if (request.getMethod().toLowerCase().trim().equals("post")){
			if (loginInfoProvider.get().isLoggedIn()) {
				return true;
			}else {
				response.sendRedirect(request.getContextPath() + "/user/login");
				return false;
			}
		}else {
			return true;
		}*/
	}
}
