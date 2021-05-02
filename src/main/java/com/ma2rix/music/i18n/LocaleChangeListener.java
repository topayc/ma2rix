package com.ma2rix.music.i18n;

import javax.servlet.ServletRequestEvent;
import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.WebUtils;

/**
 * 로케일 처리를 위한 RequestContextListener 
 *
 */
public class LocaleChangeListener extends RequestContextListener{
	@Override
	public void requestInitialized(ServletRequestEvent requestEvent) {
		super.requestInitialized(requestEvent);
		String lang = requestEvent.getServletRequest().getParameter("lang");
		if (lang != null) {
			WebUtils.setSessionAttribute( 
					(HttpServletRequest)  requestEvent.getServletRequest(), 
 			        SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, 
				    StringUtils.parseLocaleString(lang));
		}
		
	}
	
	
}
