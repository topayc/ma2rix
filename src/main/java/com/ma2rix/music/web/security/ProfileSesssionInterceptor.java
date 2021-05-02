package com.ma2rix.music.web.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ma2rix.music.model.command.ProfileCommand;
import com.ma2rix.music.model.domain.MemberLink;

/**
 * 회원 프로필 정보를 업데이트 하기 전에 관련 오브젝트를 초기화 하는 인터셉터 
 * 회원 프로필 업데이트 요청시에 적용
 * @author v
 *
 */
public class ProfileSesssionInterceptor extends HandlerInterceptorAdapter{
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) throws Exception {
			super.afterCompletion(request, response, handler, ex);
			String method = request.getMethod();
			if (method.equalsIgnoreCase("get")){
				HttpSession session = request.getSession();
				ProfileCommand profileCommand = (ProfileCommand)session.getAttribute("profileCommand");
				profileCommand.getMemberLinks().clear();
				profileCommand.getMemberFields().clear();
				profileCommand.getMemberPlays().clear();
			}
	}
}
