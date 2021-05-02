package com.ma2rix.music.common;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 쿠키 관련 유틸리티 클래스 
 * @author v
 *
 */
public class CookieManager {
       
    private HttpServletRequest request_;
	private HttpServletResponse response_;
	private HashMap<String, String> cookies_;
	
	/**
	 *메인 쿠키 키 이름 
	 */
	private final String COOKIE_MA2RIX = "CK_MA2RIX";
       
    public CookieManager(HttpServletRequest request, HttpServletResponse response) {
    	
    	this.request_  = request;
    	this.response_ = response;
    	this.cookies_  = new HashMap<String, String>();
    	boolean bReturn = initCookie();
    	if ( !bReturn ) {}
    	
    }
    
    /**
     * 쿠기를 추출하여 맵으로 변환 및 저장 
     * @return
     */
    public boolean initCookie() {
    	this.request_.getCookies();
		Cookie[] cookies = this.request_.getCookies();
		
		for ( Cookie cookie : cookies ) {
			String cookieName  = cookie.getName();
			String cookieValue = cookie.getValue();
			try {
				if ( cookieValue == null ) {
					cookieValue = "";
				} else {
					cookieValue = URLDecoder.decode(cookieValue, "UTF-8");
				}
			} catch (Exception ex) {
				this.cookies_.clear();
				//System.out.println("CookieManager.initCookie Error:" + ex.toString());
				return false;
			}
			this.cookies_.put(cookieName, cookieValue);
		}
		this.cookies_.putAll(getMainCookie());
		return true;
    }
    
    /**
     * 쿠기 추출 
     * @param cookieName 추출할 쿠키 이름
     * @return
     */
    public String getCookieValue(String cookieName) {
    	String cookieValue = this.cookies_.get(cookieName);
    	return ( cookieValue == null )?"":cookieValue;
    }
    
    /**쿠기 생성
     * @param cookieName   생성할 쿠키 이름 
     * @param cookieValue  쿠키 값
     */
    public void setCookie(String cookieName, String cookieValue) {
    	Cookie cookie = new Cookie(cookieName, cookieValue);
    	cookie.setPath("/");
    	this.response_.addCookie(cookie);
    }
    
    /**
     * 쿠기 생성 
     * @param cookieName      생성할 쿠키 이름
     * @param cookieValue     쿠키 값
     * @param cookieAgeType   쿠키 보관 시간에 대한 단위 (특별한 변환이 요구되지 않으면 널 값을 전달함
     * @param cookieAge       쿠키 보관 시간 
     */
    public void setCookie(String cookieName, String cookieValue, String cookieAgeType, int cookieAge) {
    	Cookie cookie = new Cookie(cookieName, cookieValue);
    	int maxAge = 0;
    	
    	if ( cookieAgeType == null )
			cookieAgeType = "";
    	
    	/*switch ( cookieAgeType )
    	{
    		case "S":	// Second
    			maxAge = cookieAge;
    			break;
    			
    		case "M":	// Minute
    			maxAge = cookieAge*60;
    			break;
    			
    		case "H":	// Hour
    			maxAge = cookieAge*60*60;
    			break;
    			
    		case "D":	// Day
    			maxAge = cookieAge*60*60*24;
    			break;
    			
    		default:
    			maxAge = -1;
    	}*/
    	cookie.setPath("/");
    	cookie.setMaxAge(maxAge);
    	this.response_.addCookie(cookie);
    }
    
    /**
     * 쿠기 삭제 
     * @param cookieName   삭제할 쿠키 이름 
     */
    public void deleteCookie(String cookieName) {
    	String cookieValue = "";
    	Cookie cookie = new Cookie(cookieName, cookieValue);
    	cookie.setPath("/");
    	cookie.setMaxAge(0);
    	this.response_.addCookie(cookie);
    }
    
    /**
     * 
     * main 쿠기를 가져옴 
     */
    public HashMap<String, String> getMainCookie() {
    	HashMap<String, String> mainCookie = new HashMap<String, String>();
    	String encCookie = AesCrypto.decode(getCookieValue(COOKIE_MA2RIX));
    	String decCookie = "";
    	if ( ("").equals(encCookie) ) {
    		return mainCookie;
    	}
    	decCookie = encCookie;
    	String[] cookies = decCookie.split("&");
    	for ( String cookie : cookies ) {
    		int ckIndex = cookie.indexOf("=");
    		if ( ckIndex != -1 ) {
    			String cookieName  = cookie.substring(0, ckIndex);
    			String cookieValue = cookie.substring(ckIndex+1);
    			mainCookie.put(cookieName, cookieValue);
    		}
    	}
    	return mainCookie;
    }
    
    /**
     * main 쿠기 설정
     * @param mainCookie   메인 쿠키 이름 
     * @return
     */
    public boolean setMainCookie(HashMap<String, String> mainCookie) {
    	StringBuffer buffCookie = new StringBuffer();
    	String plainCookie;
    	String encCookie;
    	for ( Map.Entry<String, String> cookie : mainCookie.entrySet() ) {
    		String cookieName  = cookie.getKey();
			String cookieValue = cookie.getValue();
			if ( buffCookie.length() > 0 ) {
				buffCookie.append("&");
			}
			buffCookie.append(cookieName+"="+cookieValue); 
    	}
    	try {
    		plainCookie = buffCookie.toString();
    		encCookie = URLEncoder.encode(AesCrypto.encode(plainCookie), "UTF-8");
    		setCookie(COOKIE_MA2RIX, encCookie);
    	} catch (Exception ex) {
    		//System.out.println("CookieManager.setMainCookie Error:" + ex.toString());
			return false;
		}
    	return true;
    }
    
    /**
     * 메인 쿠기 삭제 
     */
    public void deleteMainCookie() {
    	deleteCookie(COOKIE_MA2RIX);
    }
 
}
