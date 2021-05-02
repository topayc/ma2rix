package com.ma2rix.music.service;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ma2rix.music.common.AesCrypto;
import com.ma2rix.music.dao.interfaces.AuthenticationDao;
import com.ma2rix.music.manager.AppConstants;
import com.ma2rix.music.model.domain.Authentication;
import com.ma2rix.music.model.domain.User;
import com.ma2rix.music.model.dto.Email;
import com.ma2rix.music.service.interfaces.MailService;

/**
 * 메일 발송 클래스
 * 1. 개선 방향  
 *  - 현재는 개발 테스트 용으로 구글의 smtp 를 이용하여 보내고 있으며, 차후 별도의 메일 서버 구축이 요구됨 
 *  - 텍스트로 하드코딩된 메일 전문이 아니라, 다양한 형태의 템플릿을 사용할 수 있도록 별도로 
 *  리소스화 가 필요 
 *  - 다양한 형태의 메일 발송기능과 이와 관련한 부가 기능이 필요
 *  (메일 로그 및 관련 내용의 테이블 저장, 오류 발생시 관리자 메일 자동 발송, 특정 이벤트 발송시 로그 및 관리자 메일 발송등)
 * @author v
 *
 */
@Service
public class MailServiceImpl implements MailService {
	
	private static final String ADMIN_MAIL ="eveangun@gmail.com";
	private static final int EXPIRE_TERM_UNIT = 60*24;
	
	@Autowired private AuthenticationDao authenticationDao;
	@Autowired private JavaMailSender mailSender;
	
	@Autowired  private ServletRequest servletRequest;

	@PostConstruct
	public void init(){}
	
	@Override
	public void sendAuthenticatingMail(User user) {
		Email email = createAuthenticateEmail(user);
		sendMail(email);
	}
	
	private String getHost() {
		StringBuffer host = new StringBuffer();
		String scheme = servletRequest.getScheme();
		String serverName = servletRequest.getServerName();
		int serverPort = servletRequest.getServerPort();
		
		host.append(scheme + "://" + serverName);
		
		if ( "http".equals(scheme) ) {
			if ( serverPort != 80 )
				host.append(":" + serverPort);
		} else {
			if ( serverPort != 443 )
				host.append(":" + serverPort);
		}
		return host.toString();
	}
	
	/*
	 * 인증 메일을 발송한다.
	 */
	@Override
	public void sendMail(Email email) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true, "UTF-8");
			messageHelper.setSubject(email.getSubject());
			messageHelper.setTo(email.getReceiver());
			messageHelper.setFrom(ADMIN_MAIL);
			messageHelper.setText(email.getContent(), true);
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void sendAuthenticateMail(User user){
		Email email = createAuthenticateEmail(user);
		sendMail(email);
	}
	
	/**
	 * 회원 가입 인증 메일을 작성
	 * 
	 * @param user
	 * @return
	 */
	private Email createAuthenticateEmail(User user) {
		Email mail = new Email();
		String authenticateType = AppConstants.AuthenticateType.MEMBER_JOIN;
		String host = getHost();
		Authentication authentication = new Authentication();
		
		authentication.setMemberNo(user.getMemberNo());
		authentication.setMemberUserId(user.getMemberUserId());
		authentication.setAuthenticateType(authenticateType);
		
		String authenticateKey = createAuthenticateKey(authentication);
		System.out.println("====================> encKey : " + authenticateKey);
		
		if ( "".equals(authenticateKey) ) {
			mail = null;
		}
		else
		{
			/*
			mail.setContent("<a href = '"+HOST + "/music/user/emailAuthenticateProcess?email="
					+ user.getMemberUserId()
					+ "' > ma2rix 이메일 인증 링크</a>");
			*/
			
			mail.setContent("<a href = '" + host + "/music/user/emailAuthenticateProcess?key="
					+ authenticateKey
					+ "' > ma2rix 이메일 인증 링크</a>");
			
			System.out.println("====================> createAuthenticateEmail : " + host + "/music/user/emailAuthenticateProcess?key="+ authenticateKey);
			
			mail.setReceiver(user.getMemberUserId());
			mail.setRegdate(new Date().toString());
			mail.setSubject(user.getMemberName() + " 님의 Ma2rix 의 인증메일 발송");
		}
		
		return mail;
	}
	
	/**
	 * 비밀번호 확인 메일 발송 위한 메일 생성 
	 * @param user
	 * @return
	 */
	private Email createPassMail(User user) {
		Email mail = new Email();
		String authenticateType = AppConstants.AuthenticateType.PASSWORD_CHANGE;
		
		String host = getHost();
		
		Authentication authentication = new Authentication();
		
		authentication.setMemberNo(user.getMemberNo());
		authentication.setMemberUserId(user.getMemberUserId());
		authentication.setAuthenticateType(authenticateType);
		
		String authenticateKey = createAuthenticateKey(authentication);
		
		System.out.println("====================> encKey : " + authenticateKey);
		
		if ( "".equals(authenticateKey) ) {
			mail = null;
		}
		else
		{
			/*
			mail.setContent(user.getMemberName() + "님의 ma2rix 패스워드 정보 " + user.getMemberPwd() + "입니다");
			*/
			
			mail.setContent("<a href = '" + host + "/music/user/emailAuthenticateProcess?key="
					+ authenticateKey
					+ "' > ma2rix 비밀번호 변경 링크</a>");
			
			System.out.println("====================> createPassMail : " + host + "/music/user/emailAuthenticateProcess?key="+ authenticateKey);
			
			mail.setReceiver(user.getMemberUserId());
			mail.setRegdate(new Date().toString());
			mail.setSubject(user.getMemberName() + " 님의 패스워드 발송");
		}
		
		return mail;
	}

	/* 
	 * 패스워드 메일 발송 
	 */
	@Override
	public void sendPassMail(User user) {
		Email email =createPassMail(user);
		sendMail(email);
	}
	
	/* 
	 * 아이디 메일 발송
	 */
	@Override
	public void sendIdMail(User user) {
		Email email =createIdMail(user);
	}

	/**
	 * 아이디 확인 메일 작성 
	 * @param user
	 * @return
	 */
	private Email createIdMail(User user) {
		Email mail = new Email();
		mail.setContent(user.getMemberName() + "님의 ma2rix ID 는 " + user.getMemberUserId() + "입니다");
		mail.setReceiver(user.getMemberUserId());
		mail.setRegdate(new Date().toString());
		mail.setSubject(user.getMemberName() + " 님의 ID 발송 발송");
		return mail;
	}
	
	/**
	 * 발송 메일에 사용될 인증키를 생성
	 * @param authentication
	 * @return
	 */
	private String createAuthenticateKey(Authentication authentication) {
		
		String plainKey = "";
		String authenticateKey = "";
		
		Date currentDate = new Date();
		Date expireDate = null;
		Calendar cal = Calendar.getInstance ( );
		SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddhhmmss");
		String expireDatetime;
        
		cal.setTime ( currentDate );
		cal.add(Calendar.MINUTE, EXPIRE_TERM_UNIT);
		expireDate = cal.getTime();
		
		expireDatetime = ft.format(expireDate);
		authentication.setExpireDatetime(expireDatetime);
		
		// plainKey = authentication.getAuthenticateNo() + ";" + authentication.getExpireDatetime() + ";" + authentication.getMemberNo() + ";" + authentication.getMemberUserId();
		plainKey = authentication.getAuthenticateType() + ";" + authentication.getExpireDatetime() + ";" + authentication.getMemberNo() + ";" + authentication.getMemberUserId();
		authenticateKey = AesCrypto.encode(plainKey);
		
		authentication.setAuthenticateKey(authenticateKey);
		
		System.out.println("========================> plainKey : " + plainKey);
		System.out.println("========================> encKey : " + authenticateKey);
		
		if ( !authenticationDao.insertAuthentication(authentication) )
		{
			plainKey = "";
			authenticateKey = "";
		}
		
		System.out.println("========================> plainKey2 : " + plainKey);
		System.out.println("========================> encKey2 : " + authenticateKey);
		
		return authenticateKey;
	}
	
	/* 
	 * 유저의 인증 여부 확인 
	 */
	@Override
	public Authentication isAuthentication(Authentication authentication) {
		
		Authentication authResult;
		String plainKey = "";
		String[] authenticateData; 
		String currentDatetime;
		SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddhhmmss");
        
		currentDatetime = ft.format(new Date());
		
		plainKey = AesCrypto.decode(authentication.getAuthenticateKey());
		
		if ( "".equals(plainKey) ) {
			authentication.setAuthenticateResult(AppConstants.AuthenticateResult.ERROR_ROUTE);
			return authentication;
		}
		
		authenticateData = plainKey.split(";");
		
		if ( authenticateData.length < 4 ) {
			authentication.setAuthenticateResult(AppConstants.AuthenticateResult.ERROR_ROUTE);
			return authentication;
		}
		
		authentication.setAuthenticateType(authenticateData[0]);
		authentication.setExpireDatetime(authenticateData[1]);
		authentication.setMemberNo(Integer.parseInt(authenticateData[2]));
		authentication.setMemberUserId(authenticateData[3]);
		
		System.out.println("=============================> isAuthentication start");
		System.out.println("=============================> plainKey:" + plainKey);
		System.out.println("=============================> AuthenticateType:" + authentication.getAuthenticateType());
		System.out.println("=============================> ExpireDatetime:" + authentication.getExpireDatetime());
		System.out.println("=============================> MemberNo:" + authentication.getMemberNo());
		System.out.println("=============================> MemberUserId:" + authentication.getMemberUserId());
		
		authResult = authenticationDao.getAuthenticationByAuthenticateKey(authentication.getAuthenticateKey());
		
		if ( authResult == null ) {
			authentication.setAuthenticateResult(AppConstants.AuthenticateResult.ERROR_EXPIRE);
			return authentication;
		} else {
			authResult.setAuthenticateResult(AppConstants.AuthenticateResult.ERROR_EXPIRE);
			authentication = authResult;
		}
		
		System.out.println("=============================> AuthenticateNo:" + authentication.getAuthenticateNo());
		
		if ( currentDatetime.compareTo(authentication.getExpireDatetime()) > 0 ) {
			authenticationDao.deleteAuthentication(authResult.getAuthenticateNo());
			authentication.setAuthenticateResult(AppConstants.AuthenticateResult.ERROR_EXPIRE);
			return authentication;
		}
		
		authentication.setAuthenticateResult(AppConstants.AuthenticateResult.SUCCESS);
		return authentication;
	}
	
	/* 
	 * 인증 임시 테이블의 내용을 삭제
	 * 인증이 완료된 경우 호출됨 
	 */
	public void deleteAuthentication(int authenticateNo) {
		authenticationDao.deleteAuthentication(authenticateNo);
	}
}
