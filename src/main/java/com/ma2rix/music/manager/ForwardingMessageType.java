package com.ma2rix.music.manager;


/**
 * 서버 응답 메시지를 위한 enum 클래스 
 * 차후 메시지 다국화 스프링 다국화 기능을 이용할 때 활용이 가능
 * 
 * 다국어 지원 방법 1 
   - 언어별 메시지를 담고 있는 enum 를 생성( 혹은 언어별 리소스 파일을 작성해서 어플리케이션 시작시 메세지 초기화) 
   - 언어 관리를 위한 별도의 클래스를 작성해서, 언어별 알맞은 enum 를 선택해서 메시지 생성 
   
 * 다국어 지원 방법 1
  - 스프링을 이용한 지원 : 스프링의 로케일 결정방법에 따라 알맞은 메시지 생성 
  - 각 언어별로 리소스 파일 작성   
 * @author v
 *
 */
public enum ForwardingMessageType {
	
	LOGIN_FAIL						(1,	 "title.composition.list",		"이이디와 비밀번호를 확인해 주세요. </br>ma2rix에 등록되지 않은 아이디 또는 비밀번호를 입력하셨습니다." ),
	LOGIN_SUCCESS					(2,	 "로그인 성공",					"이제 Ma2rix에서 원하는 음악을 자유롭게 만들어 보세요.<br/>만드신 음악은 또한 다른 유저들에게 널리 홍보도 됩니다"),
	PROFILE_UPDATE_SUCCESS 		(3,	 "업데이트 완료",				"입력하신 정보로 성공적으로 업데이트 했습니다."),
	PROFILE_UPDATE_FAIL			(4,	 "업데이트 실패",				"일시적인 문제로 업데이트가  실패했습니다. 다시 시도해 주십시오"),
	JOIN_SUCCESS					(5,	 "회원 가입 완료",				"이제 Ma2rix에서 원하는 음악을 자유롭게 만들어 보세요.<br/>만드신 음악은 또한 다른 유저들에게 널리 홍보도 됩니다"),
	JOIN_FAIL						(6,	 "회원 가입 실패",				"일시적인 문제로 회원가입이  실패했습니다. 다시 시도해 주십시오"),
	AUTHENTICATE_SUCCESS			(7,	 "인증 성공",					"인증이 성공하였습니다"),
	AUTHENTICATE_FAIL				(8,	 "인증 실패",					"인증이 실패했습니다."),
	SEND_AUTHENTICATE_MAIL		(9,	 "인증 메일 발송 완료",			"등록하신 메일로 인증 메일을 발송했습니다."),
	SEND_PASSWORD_MAIL			(10, "비밀번호 발송 완료.",			"등록하신 메일로 비밀번호를 발송했습니다."),
	SEND_ID_MAIL					(11, "아이디 발송완료", 			"입력하신 email 로 아이디를 발송했습니다"),
	LOGOUT_SUCCESS 				(12, "로그 아웃 완료",				"성공적으로 로그아웃 되었습니다"),
	LOGOUT_FAIL					(13, "로그아웃 실패",				"일시적인 문제로 로그아웃을 실패했습니다. 다시 시도해 주세요"),
	SEARCH_ID						(14, "아이디 찾기", 				"아이디를 찾을 수 있는 email 을 입력해주세요"),
	SEARCH_PASSWORD				(15, "비밀번호 찾기", 				"비밀번호를 변경할 수 있는 링크를 받기 위한 email 를 입력해주세요"),
	NOT_REGISTERED_EMAIL			(16, "이메일 오류 ", 				"입력하신 이메일이 등록되어 있지 않습니다. 다시 한번 확인해주세요"),
	ARRANGE_UPDATE_SUCCESS		(17, "업데이트 완료", 				"입력하신 내용대로 업데이트를 완료했습니다."),
	ARRANGE_UPDATE_FAIL			(18, "업데이트 실패", 				"업데이트가 실패했습니다. 다시 한번 시도해주세요."),
	INVALID_MAIL					(19, "잘못된 이메일", 				"잘못된 형식의 이메일입니다. 다시 확인해주세요"),
	BEFORE_EMAIL_AUTHENTICATE	(20, "이메일 인증전", 				"현재 회원님은 이메일 인증전입니다. 이메일 인증을 해주세요"),
	FAIL_EMAIL_AUTH 				(21, "이메일 인증 실패", 			"이메일인증이 실패했습니다.다시 한번 이메일 인증을 해주시기 바랍니다"),
	SUCCESS_EMAIL_AUTH 			(22, "이메일 인증 실패", 			"이메일인증이 실패했습니다.다시 한번 이메일 인증을 해주시기 바랍니다"),
	SUCCESS_PASSWORD_AUTH		(23, "비밀번호 변경 인증 성공", 	"비밀번호 변경 인증이 성공했습니다"),
	FAIL_PASSWORD_AUTH			(24, "비밀번호 변경 인증 실패 ", 	"비밀번호 변경 인증이 실패했습니다. 다시 한번 시도해주세요 "),
	FOREC_DRAW_USER				(25, "관리자에 의한 강제 탈퇴", 	"회원님은 현재 강제 탈퇴 상태입니다. 자세한 사항은 아래의 링크로 문의해주세요"),
	RESERVATION_USER				(26, "회원 승인 보류 상태", 		"회원 님은 현재 회원 가입 보류 상태입니다. 자세한 사항은 아래의 링크로 문의해주세요");
	
	private int messageType;
	private String mainMessageCode;
	private String subMessageCode;
	
	private ForwardingMessageType(int messageType, String mainMessageCode,
			String subMessageCode) {
		this.messageType = messageType;
		this.mainMessageCode = mainMessageCode;
		this.subMessageCode = subMessageCode;
	}

	public int messageType(){return this.messageType;}
	public String mainMessageCode(){return this.mainMessageCode;}
	public String subMessageCode(){return this.subMessageCode;}
	
	public static ForwardingMessageType valueOf(int value){
		switch(value)
		{
			case 1: return LOGIN_FAIL;
			case 2: return LOGIN_SUCCESS;
			case 3: return PROFILE_UPDATE_SUCCESS;
			case 4: return PROFILE_UPDATE_FAIL;
			case 5: return JOIN_SUCCESS;
			case 6: return JOIN_FAIL;
			case 7: return AUTHENTICATE_SUCCESS;
			case 8: return AUTHENTICATE_FAIL;
			case 9: return SEND_AUTHENTICATE_MAIL;
			case 10: return SEND_PASSWORD_MAIL;
			case 11: return LOGOUT_SUCCESS;
			case 12: return LOGOUT_FAIL;
			case 13: return SEARCH_ID;
			case 14: return SEARCH_PASSWORD;
			case 15: return NOT_REGISTERED_EMAIL;
			case 16: return SEND_ID_MAIL;
			case 17: return ARRANGE_UPDATE_SUCCESS;
			case 18: return ARRANGE_UPDATE_FAIL;
			case 19: return INVALID_MAIL;
			case 20: return BEFORE_EMAIL_AUTHENTICATE;
			case 21: return FAIL_EMAIL_AUTH;
			case 22: return SUCCESS_EMAIL_AUTH;
			case 23: return SUCCESS_PASSWORD_AUTH;
			case 24: return FAIL_PASSWORD_AUTH;
			case 25: return FOREC_DRAW_USER;
		}
		return null;
	}
}