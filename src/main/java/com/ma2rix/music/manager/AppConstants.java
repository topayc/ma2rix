package com.ma2rix.music.manager;

/**
 * Ma2rix 에서 사용되는 상수 클래스 
 * @author v
 *
 */
public final  class AppConstants {
	
	/* 사용 여부 */
	public static final class Available {
		public static final String CLASS_CODE 					= "MA001"; 
		public static final String USE 							= "Y";
		public static final String NOT_USE						= "N";
	}
	
	/* 가입 경로*/  
	public static final class Route {
		public static final String CLASS_CODE 					= "MA002"; 
		public static final String EMAIL							= "01";
		public static final String FACEBOOK 						= "02";
		public static final String GOOGLE				        = "03";
		public static final String ETC						    = "99";
	}
	
	/* 회원 상태*/  
	public static final class UserStatus {
		public static final String CLASS_CODE 					= "MA003"; 
		public static final String CONFIRM_JOIN					= "01";
		public static final String WIDTHDRAW						= "02";
		public static final String FORCE_WITHDRAW				= "03";
		public static final String BEFORE_AUTHENTICATE		    = "09";
		public static final String RESERVATION					= "99";	
	}
	
	/*관리자 상태*/  
	public static final class AdminStatus{
		public static final String CLASS_CODE 					= "MA004"; 
		public static final String JOIN							= "01";
		public static final String WIDTHDRAW						= "02";
		public static final String RESERVATION					= "99";
	}
	
	/* 뮤지션 활동 뷴야*/  
	public static final class Activity {
		public static final String CLASS_CODE 					= "MA005"; 
		public static final String COMPOSE						= "01";
		public static final String ARRANGE						= "02";
		public static final String PERFORM						= "03";
		public static final String LYLICS						= "04";
		public static final String VOCAL							= "05";
	}
	
	/* 공개 여부*/  
	public static final class OpenStatus{
		public static final String CLASS_CODE 					= "MA006"; 
		public static final String OPEN							= "Y";
		public static final String NOT_OPEN						= "N";
	}
	
	/* 음원 단계*/  
	public static final class MusicStep {
		public static final String CLASS_CODE 					= "MA007"; 
		public static final String COMPOSE				= "01";
		public static final String ARRANGE				= "02";
		public static final String COMPLETE				= "02";
		
	}
	
	/* 음원 분류*/  
	public static final class MusicClass {
		public static final String CLASS_CODE 					= "MA008"; 
		public static final String COMPOSE						= "01";
		public static final String ARRANGE						= "02";
		public static final String PERFORM						= "03";
		public static final String LYLICS						= "04";
		public static final String VOCAL							= "05";	
	}
	
	/* 유료 여부*/  
	public static final class Charge {
		public static final String CLASS_CODE 					= "MA009"; 
		public static final String PAY							= "Y";
		public static final String FREE							= "N";
	}
	
	/* 작곡 상태*/  
	public static final class ComposeStatus{
		public static final String CLASS_CODE 					= "MA010"; 
		public static final String COMPOSING						= "01";
		public static final String COMPOSE_COMPLETED			= "02";
	}
	
	/* 판매 상태*/  
	public static final class SalesStatus {
		public static final String CLASS_CODE 					= "MA011"; 
		public static final String BEFORE_SALE					= "01";
		public static final String ON_SALE						= "02";
		public static final String STOP_SALE						= "03";
		public static final String STOP_SALE_BY_ADMIN			= "09";
		public static final String REMOVE_BY_ADMIN				= "99";
	}
	
	/* 편곡 상태*/  
	public static final class ArrangeStatus {
		public static final String CLASS_CODE 					= "MA012"; 
		public static final String REGISTERING_ARRANGE			= "01";
		public static final String ARRANGING						= "02";
		public static final String ARRANGE_COMPLETED			= "03";
				
	}
	
	/* 보컬 상태*/  
	public static final class VocalStatus {
		public static final String CLASS_CODE 					= "MA013"; 
		public static final String REGISTER_VOCAL				= "01";
		public static final String VOCAL_COMPLETED				= "02";
	}
	
	/* 배포 제한*/  
	public static final class PublishLimit {
		public static final String CLASS_CODE 					= "MA014"; 
		public static final String LIMIT							= "Y";
		public static final String NOT_LIMIT						= "N";
	}
	
	/* 연주 상태*/  
	public static final class PerformStatus {
		public static final String CLASS_CODE 					= "MA015"; 
		public static final String WAITING_PERFORMER			= "00";
		public static final String REGISTERING_PERFORM			= "01";
		public static final String PERFORM_COMPLETED			= "02";
		public static final String WIDTHDRAW						= "09";
		public static final String FORCE_WITHDRAW				= "99";
	}
	
	/* 확정 여부*/  
	public static final class ConfirmStatus {
		public static final String CLASS_CODE 					= "MA016"; 
		public static final String CONFIRM						= "Y";
		public static final String NOT_CONFIRM					= "N";
	}
	
	/* 선택 여부*/  
	public static final class SelectStatus {
		public static final String CLASS_CODE 					= "MA017"; 
		public static final String SELECT						= "Y";
		public static final String NOT_SELECT					= "N";
		
	}
	
	/* 작사 상태*/  
	public static final class LylicsStatus {
		public static final String CLASS_CODE 					= "MA018"; 
		public static final String LYLICSING						= "01";
		public static final String LYLICS_REGISTER_COMPLETED	= "02";
		public static final String REMOVE						= "09";
		public static final String REMOVE_FORCE					= "99";
	}
	
	/* 노출 여부*/  
	public static final class ExposeStatus {
		public static final String CLASS_CODE 					= "MA019"; 
		public static final String EXPOSE						= "01";
		public static final String NOT_EXPOSE					= "02";
	}
	
	/* 수신 상태*/  
	public static final class ReceiveStatus {
		public static final String CLASS_CODE 					= "MA020"; 
		public static final String CHOOSE_RECEIVE				= "Y";
		public static final String CHOOSE_NOT_RECEIVE			= "N";
	}
	
	/* 게시판 분류*/  
	public static final class BoardType {
		public static final String CLASS_CODE 					= "MA021"; 
	}
	
	/* 전송 구분*/  
	public static final class TransferType {
		public static final String CLASS_CODE 					= "MA022"; 
		public static final String SEND							= "S";
		public static final String RECEIVE 						= "R";
	}
	
	/* 메시지 구분*/  
	public static final class MessageStatus {
		public static final String CLASS_CODE 					= "MA023"; 
		
	}
	
	/* 메시지 읽기 상태*/  
	public static final class MessageReadStatus {
		public static final String CLASS_CODE 					= "MA024"; 
		public static final String READ							= "Y";
		public static final String NOT_READ 						= "N";
	}
	
	public static final class VocalStatusEx {
		public static final String CLASS_CODE 					= "MA025"; 
	}
	
	/* 수수료 타입*/  
	public static final class CommissionType {
		public static final String CLASS_CODE 					= "MA028"; 
	}
	
	/* PG 상태*/  
	public static final class PGStatus {
		public static final String CLASS_CODE 					= "MA027"; 
	}
	
	/* 결제 종류*/  
	public static final class PaymentType {
		public static final String CLASS_CODE 					= "MA028"; 
		public static final String SALE							= "01";
		public static final String BALANCE_ACCOUNT				= "02"; 
	}
	
	/* 결제 상태*/  
	public static final class PaymentStatus {
		public static final String CLASS_CODE 					= "MA029"; 
		public static final String PAYMENT_STAND_BY 			= "00";
		public static final String PAYMENT_COMPLETED			= "01";
		public static final String PAYMENT_FAIL 				= "02";
		public static final String PAYMENT_CANCEL 				= "03";
		public static final String PAYMENT_REFUND 				= "04";
	}
	
	/* 매출 상품*/  
	public static final class SalesProduct {
		public static final String CLASS_CODE 					= "MA030"; 
	}
	
	/* 정산 상태*/  
	public static final class AdjustmentStatus {
		public static final String CLASS_CODE 					= "MA031"; 
	}
	
	/* 게시글 상태*/  
	public static final class ArticleStatus{
		public static final String CLASS_CODE 					= "MA032"; 
	}
	
	/* 게시글 타입*/  
	public static final class ArticleType {
		public static final String CLASS_CODE 					= "MA033"; 
	}
	
	/* 인증 종류*/  
	public static final class AuthType {
		public static final String CLASS_CODE 					= "MA034"; 
	}
	
	public static final class ListType {
		public static final int LISTED_COMPOSE                 = 1;
		public static final int LISTED_ARRANGING				= 2;
		public static final int LISTED_ARRANGE_COMPLETED		= 3;
		public static final int LISTED_VOCAL					= 4;
	}
	
	public static final class ActionType {
		public static final int UPDATE							= 1;
		public static final int INSERT							= 2;
		public static final int DELETE							= 3;
	}
	
	/**
	 * 
	 * 작곡 편곡 등의 등록 페이지에서 지정 상대방에서 메시지를 보냈는지 보내지 않았는 지의 
	 * 상수 클래스 
	 * @author v
	 *
	 */
	public static final class FormMessageSendingStatus {
		public static final String MESSAGE_SENDED     		 = "Y";
		public static final String MESSAGE_NOT_SENDED       = "N";
	}
	
	/**
	 * 작곡 편곡 등록 페이지에서 지정 상태방에서 보낸 메시지의 타입을 정의 
	 *
	 */
	public static final class FormUpdateType {
		public static final int ACTION_TYPE_INIT 			= 1;
		public static final int ACTION_TYPE_UPDATE 		= 2;
		public static final int ACTION_TYPE_DELETE 		= 3;
		public static final int ACTION_TYPE_INSERT 		= 4;
		
	}
	
	public static class Ma2Resource {
		public static final String DEFAULT_COMPOSE_COVER_IMAGE	 = "../resources/images/holderType3.gif";
		public static final String DEFAULT_ARRANGE_COVER_IMAGE 	 = "../resources/images/holderType3.gif";
		public static final String DEFAULT_VOACL_COVER_IMAGE 		 = "../resources/images/holderType3.gif";
		
		public static final String DEFAULT_FREQUENCY_IMAGE         = "../resources/images/holderType2.gif";
		public static final String DEFRAULT_PRFILE_IMAGE			 = " ";
		
	}
	 
	public static final class Session{
		public static final String USER_SESSION_IN 		= "1";
		public static final String USER_SESSION_OUT 	= "0";
	}
	
	public static class AuthenticateType {
		public static final String MEMBER_JOIN		= "01";
		public static final String PASSWORD_CHANGE	= "02";
	}
	
	public static class AuthenticateResult {
		public static final String SUCCESS			= "00";
		public static final String ERROR_EXPIRE		= "01";
		public static final String ERROR_ROUTE		= "03";
		public static final String ERROR_SERVER		= "04";
	}
	
	public static class InputType {
		public static final int USER_INPUT_PLAY_FIEID= 1;
		
	}
}

