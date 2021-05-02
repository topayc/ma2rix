package com.ma2rix.music.web.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ma2rix.music.common.CommonUtils;
import com.ma2rix.music.manager.AppConstants;
import com.ma2rix.music.manager.ForwardingMessageType;
import com.ma2rix.music.model.command.JoinCommand;
import com.ma2rix.music.model.command.LoginCommand;
import com.ma2rix.music.model.command.MailSendRequest;
import com.ma2rix.music.model.command.ProfileCommand;
import com.ma2rix.music.model.domain.Authentication;
import com.ma2rix.music.model.domain.Code;
import com.ma2rix.music.model.domain.CodeClass;
import com.ma2rix.music.model.domain.Country;
import com.ma2rix.music.model.domain.MemberField;
import com.ma2rix.music.model.domain.MemberPlay;
import com.ma2rix.music.model.domain.PlayField;
import com.ma2rix.music.model.domain.User;
import com.ma2rix.music.model.dto.ForwardingMessage;
import com.ma2rix.music.model.dto.ajaxresponse.DuplicateResponse;
import com.ma2rix.music.service.interfaces.CodeService;
import com.ma2rix.music.service.interfaces.CountryService;
import com.ma2rix.music.service.interfaces.MailService;
import com.ma2rix.music.service.interfaces.MemberFieldService;
import com.ma2rix.music.service.interfaces.MemberLinkService;
import com.ma2rix.music.service.interfaces.MemberPlayService;
import com.ma2rix.music.service.interfaces.PlayFieldService;
import com.ma2rix.music.service.interfaces.UserService;
import com.ma2rix.music.web.security.LoginInfo;
import com.ma2rix.music.web.validator.JoinValidator;
import com.ma2rix.music.web.validator.LoginValidator;

@Controller
@RequestMapping("/user")
@SessionAttributes({"user",
					"loginCommand",
					"joinCommand",
					"userUpdateCommand",
					"mailSendRequest",
					"profileCommand"})

public class UserController extends ApplicationController{
	
	public static class UserForward{
		public static final String ACTION_RESULT_VIEW   					= "user/actionResult";
		public static final String LOGIN_FORM_VIEW 							= "user/login";
		public static final String SEARCH_PAGE_VIEW 						= "user/searchPage";
		public static final String SEARCH_RESULT_VIEW 						= "user/searchResult";
		public static final String LOGIN_SUCCESS_VIEW 						= "user/loginSuccess";
		public static final String EMAIL_AUTHENTICATE_FORM_VIEW 			= "user/emailAuthenticateForm";
		public static final String JOIN_STEP1_VIEW 							= "user/join_step1";
		public static final String JOIN_STEP2_VIEW 							= "user/join_step2";
		public static final String JOIN_STEP3_VIEW 							= "user/join_step3";
		public static final String JOIN_STEP4_VIEW 							= "user/join_step4";
		public static final String PROFILE_VIEW 							= "user/profile";
		public static final String SEND_AUTHENTICATE_MAIL_SUCCESS_VIEW 	= "user/sendAuthenticateMailSuccess";
		public static final String SEND_PASSWORD_MAIL_SUCCESS_VIEW 		= "user/sendPasswordMailSuccess";
		public static final String AUTHENTICATE_MAIL_SUCCESS_VIEW 		= "user/authenticateMaillSuccess";
		public static final String AUTHENTICATE_MAIL_FAIL_VIEW 			= "user/authenticateMaillFail";
		public static final String UPDATE_SUCCESS_VIEW 					= "user/updateSuccess";
	}
	
	public static class UserRedirect {
		public static final String ACTION_RESULT   							= "redirect:/user/actionResult";
		public static final String LOGIN 									= "redirect:/user/login";
		public static final String LOGIN_SUCCESS 							= "redirect:/user/loginSuccess";
		public static final String LOGIN_FAIL 								= "redirect:/user/loginFail";
		public static final String MAIN 										= "redirect:/main";
		public static final String EMAIL_AUTHENTICATE					    = "redirect:/user/emailAuthenticate";
		public static final String SEND_AUTHENTICATE_MAIL_SUCCESS 		= "redirect:/user/sendAuthenticateMailSuccess";
		public static final String AUTHENTICATE_BY_MAILL_SUCCESS 			= "redirect:/user/authenticateMaillSuccess";
		public static final String AUTHENTICATE_BY_MAILL_FAIL 			= "redirect:/user/authenticateMaillFail";
		public static final String SEND_MAIL_SUCCESS 						= "redirect:/user/sendMailSuccess";
		public static final String SEND_PASSWORD_MAIL_SUCCESS 			= "redirect:/user/sendPasswordMailSuccess";
		public static final String JOIN 										= "redirect:/user/join";
		public static final String JOIN_MAIN 								= "redirect:/user/joinMain";
		public static final String UPDATE_SUCCESS 							= "redirect:/user/updateSuccess";
		public static final String UPDATE_FAIL							    = "redirect:/user/updateFail";
		
		public static final String JOIN_STEP1 								= "redirect:/user/join_step1";
		public static final String JOIN_STEP2 								= "redirect:/user/join_step2";
		public static final String JOIN_STEP3 								= "redirect:/user/join_step3";
		public static final String JOIN_STEP4 								= "redirect:/user/join_step4";
		public static final String SEARCH_RESULT 							= "redirect:/user/searchResult";
	}

	@Autowired private UserService userService;
	@Autowired private PlayFieldService playFieldService;
	@Autowired private CodeService codeService;
	@Autowired private MailService mailService;
	@Autowired private MemberPlayService memberPlayService;
	@Autowired private MemberFieldService memberFieldSerivce;
	@Autowired private MemberLinkService memberLinkService;
	@Autowired private CountryService countryService;

	@Autowired private LoginValidator loginValidator;
	@Autowired private JoinValidator joinValidator;
	
	/**
	 * 활동분야 리스트를 반환하는 ModelAttribute 메서드 
	 * ( 작곡가, 작사가, 편곡자, 연주자, 보컬) 
	 * @return 활동분야 리스트 
	 */

	public ArrayList<Code> prepareActivities(){
		ArrayList<Code> activityList = codeService.getCodesByCodeClassId(CodeClass.MEMBER_FIELDS);
		return activityList;
	}
	
	/**
	 * 등록된 연주 분야 리스트를 가져온다.
	 * (기타, 드럼, 피아노, 베이스등) 
	 * @return
	 */
	
	public ArrayList<PlayField> preparePlayFields(){
		return playFieldService.getAllPlayFields();
	}

	/**
	 * 국가 리스트를 가져온다.
	 * @return
	 */
	public ArrayList<Country> prepareContries(){
		return countryService.getAllCountries();
	}
	
	/**
	 * 로긴 폼 요청을 처리 
	 * @param model 모델을 담기 위한 모델맵
	 * @param locale 해당 사용자이 로케일 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm(
				ModelMap model, 
			    Locale locale,
			    HttpServletRequest req,
				@CookieValue(value = "emailCookie", required = false) String emailCookie ) {
		
		LoginCommand loginCommand = new LoginCommand();
		setLocal(model, req);
		if ( emailCookie != null && !"".equals(emailCookie)) {
			loginCommand.setEmailCookie(true);
		}
		
		model.addAttribute("loginCommand", new LoginCommand());
		return UserForward.LOGIN_FORM_VIEW;
	}

	/**
	 * 로그인 요청을 처리, 사용자의 아이디 기억 여부 설정에 따라 쿠키를 설정
	 * @param loginCommand 사용자가 로긴 폼에서 입력한 내용이 담겨 있는 오브젝트 
	 * @param bindindResult 바인딩 과정에서의 오류를 담고 있는 오브젝트 
	 * @param status 세션처리를 위한 오브젝트 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String Login(
			@ModelAttribute("loginCommand") LoginCommand loginCommand,
			BindingResult result,
			ModelMap model, 
			SessionStatus status,
			HttpServletResponse response,
			RedirectAttributes attr) {
		
		LoginInfo loginInfo= null;
		String returnUrl = null;
		boolean sessionCompleted = false;
		
		System.out.println(">>getLoginRoute::"+loginCommand.getLoginRoute());
		
		/* ma2rix 로그인 */
		if (loginCommand.getLoginRoute()==null || loginCommand.getLoginRoute().equals("MA")){
		
			if (result.hasErrors()) {
				return UserForward.LOGIN_FORM_VIEW;		
			}
			
			this.loginValidator.validate(loginCommand, result);
			if (result.hasErrors()){
				return UserForward.LOGIN_FORM_VIEW;
			}
			
			User user = userService.getUserByEmailAndPassword(loginCommand.getEmail(),loginCommand.getPassword());
			
			if (user == null){
				model.addAttribute("message",prepareForwardingMessage(ForwardingMessageType.LOGIN_FAIL));
				return returnUrl =  UserForward.LOGIN_FORM_VIEW;	
			}

			if (user.getMemberStatus().equals(AppConstants.UserStatus.BEFORE_AUTHENTICATE) ){
				result.reject("before auth enticate", "beforauthenticate");
				sessionCompleted = true;
				attr.addFlashAttribute("message", prepareForwardingMessage(ForwardingMessageType.BEFORE_EMAIL_AUTHENTICATE));
				returnUrl = UserRedirect.EMAIL_AUTHENTICATE;
			}
				
			else if (user.getMemberStatus().equals(AppConstants.UserStatus.FORCE_WITHDRAW) 
												|| user.getMemberStatus().equals(AppConstants.UserStatus.WIDTHDRAW) ){
				result.reject("not member", "not member");
				sessionCompleted = true;
				attr.addFlashAttribute("message",prepareForwardingMessage(ForwardingMessageType.FOREC_DRAW_USER));
				returnUrl = UserRedirect.LOGIN;
			}
				
			else if (user.getMemberStatus().equals(AppConstants.UserStatus.RESERVATION)){
				result.reject("reservation", "reservation");
				sessionCompleted = true;
				attr.addFlashAttribute("message", prepareForwardingMessage(ForwardingMessageType.RESERVATION_USER));
				returnUrl = UserRedirect.LOGIN;
			}
				
			else if (user.getMemberStatus().equals(AppConstants.UserStatus.CONFIRM_JOIN)){
				loginInfo = loginInfoProvider.get();
				user.initLastLoginDateTime();
						
				/*
				 * updating user's login time  
				   userService.updateUser(user);
				*/
				/*put the user info into session*/
				loginInfo.setCurrentUser(user);
				sessionCompleted = true;	
				
				/*create and remove cookie with servelt api */
				Cookie cookie = new Cookie("emailCookie", loginCommand.getEmail());
				if (loginCommand.isEmailCookie() == true){
						
					cookie.setMaxAge(60 * 60 * 24 * 365);
					response.addCookie(cookie);
				}else {
						cookie.setMaxAge(0);
						response.addCookie(cookie);
				}
						
					/* create and remove cookie with spring cookie api
		  
					CookieGenerator cGenerate = new CookieGenerator();
					if (loginCommand.isEmailCookie() == true){
						cGenerate.setCookieName("emailCookie");
						cGenerate.addCookie(response,loginCommand.getEmail());
					}else {
						cGenerate.removeCookie(response);
					}*/
				ForwardingMessage message = prepareForwardingMessage(ForwardingMessageType.LOGIN_SUCCESS);
				attr.addFlashAttribute("message", message);
				attr.addFlashAttribute("userSession", AppConstants.Session.USER_SESSION_IN);	

				returnUrl = UserRedirect.ACTION_RESULT;
	
			}
		/* facebook 로그인 */	
		}else if(loginCommand.getLoginRoute().equals("FB")){
			User user = userService.getUserByEmailAndPassword(loginCommand.getEmail(),loginCommand.getPassword());
			loginInfo = loginInfoProvider.get();
			user.initLastLoginDateTime();
			user.setMemberName(loginCommand.getFbusername());
			user.setMemberUserId(loginCommand.getFbuserid());
			loginInfo.setCurrentUser(user);
			sessionCompleted = true;	
			

			ForwardingMessage message = prepareForwardingMessage(ForwardingMessageType.LOGIN_SUCCESS);
			attr.addFlashAttribute("message", message);
			attr.addFlashAttribute("userSession", AppConstants.Session.USER_SESSION_IN);	
			returnUrl = UserRedirect.ACTION_RESULT;
		
		/* google 로그인 */	
		}else if(loginCommand.getLoginRoute().equals("GG")){
			User user = userService.getUserByEmailAndPassword(loginCommand.getEmail(),loginCommand.getPassword());
			loginInfo = loginInfoProvider.get();
			user.initLastLoginDateTime();
			user.setMemberName(loginCommand.getGgusername());
			user.setMemberUserId(loginCommand.getGguserid());
			loginInfo.setCurrentUser(user);
			sessionCompleted = true;	

			ForwardingMessage message = prepareForwardingMessage(ForwardingMessageType.LOGIN_SUCCESS);
			attr.addFlashAttribute("message", message);

			attr.addFlashAttribute("userSession", AppConstants.Session.USER_SESSION_IN);	


			returnUrl = UserRedirect.ACTION_RESULT;
		}
		
		if (sessionCompleted == true) status.setComplete();
		return returnUrl;
	}
	
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(RedirectAttributes attr){
		LoginInfo loginInfo = loginInfoProvider.get();
		loginInfo.setCurrentUser(null);
		
		ForwardingMessage message = prepareForwardingMessage(ForwardingMessageType.LOGOUT_SUCCESS);
		attr.addFlashAttribute("message", message);
		attr.addFlashAttribute("userSession",  AppConstants.Session.USER_SESSION_OUT);
		return UserRedirect.ACTION_RESULT;
	}
	
	@RequestMapping(value = "/actionResult", method = RequestMethod.GET)
	public String actionResult(){
		return UserForward.ACTION_RESULT_VIEW;
	}
	
	
	/**
	 * 회원 가입 요청 메인 요청을 처리
	 */
	@RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
	public String loginSuccess() {
		return UserForward.LOGIN_SUCCESS_VIEW;
	}

	/**
	 * 회원 가입 요청 메인 요청을 처리
	 * @param model 모델을 담기 위한 모델맵 
	 * @return
	 */
	@RequestMapping(value = "/join_step1", method = RequestMethod.GET)
	public String showJoinStep1Form(ModelMap model) {
		model.addAttribute("joinCommand", new JoinCommand());
		return UserForward.JOIN_STEP1_VIEW;
	}
	
	/**
	 * 회원 가입 세부 폼 요청 처리 
	 * @param join
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/join_step2", method = RequestMethod.GET)
	public String showJoinStep2Form(
			ModelMap model,
			@RequestHeader(value = "Referer", required = false) String referer) {	
		
		if (referer == null ) return UserRedirect.JOIN_STEP1;
		model.addAttribute("joinCommand", new JoinCommand());
		return UserForward.JOIN_STEP2_VIEW;
	}
	
	@RequestMapping(value = "/join_step2", method = RequestMethod.POST)
	public String joinStep2(
			@ModelAttribute JoinCommand joinCommand,
			BindingResult result,
			ModelMap model,
			@RequestHeader("referer") String referer,
			SessionStatus status) {	
		
		if (referer == null ) return UserRedirect.JOIN_STEP1;
		if (result.hasErrors()) return UserForward.JOIN_STEP1_VIEW;
		
		if (joinCommand.isAgreePersonalProtect() == false || joinCommand.isAgreeUsePolicy() == false) 
			return UserForward.JOIN_STEP2_VIEW;
		status.setComplete();
		return UserRedirect.JOIN_STEP3;
	}
	
	@RequestMapping(value = "/join_step3", method = RequestMethod.GET)
	public String showJoinStep3Form(
			ModelMap model,
			@RequestHeader(value = "Referer", required = false) String referer) {	
		if (referer == null || "".equals(referer)) return UserRedirect.JOIN_STEP1;
		model.addAttribute("activities", prepareActivities());
		model.addAttribute("playFields",preparePlayFields());
		return UserForward.JOIN_STEP3_VIEW;
	}
	
	@RequestMapping(value = "/join_step3", method = RequestMethod.POST)
	public String joinStep3(
			@RequestParam String email,
			@RequestParam String password,
			@RequestParam String passwordConfirm,
			@RequestParam String name,
			@RequestParam String nickName,
			@RequestParam String[] activities,
			@RequestParam int[] memberPlay1,
			@RequestParam String[] memberPlay2,
			RedirectAttributes attr){
		
		User user = new User();
		user.setMemberUserId(email);
		user.setMemberName(name);
		user.setMemberPwd(password);
		user.setMemberNickName(nickName);
		user.setMemberStatus(AppConstants.UserStatus.BEFORE_AUTHENTICATE);
		user.setMemberRoute("01");
		user.setModAdminNo(1);
		user.setEmailReceive("y");
		
		userService.insertUser(user);
		
		ArrayList<MemberField> memberFields = new ArrayList<MemberField>();
		
		if (activities != null){
			MemberField memberField;
			for (int i = 0 ; i < activities.length; i++){
				memberField = new MemberField();
				memberField.setMusicField(activities[i]);
				memberField.setMemberNo(user.getMemberNo());
				memberFields.add(memberField);
			}
		}
		
		ArrayList<PlayField> playFieldList = playFieldService.getAllPlayFields();
		ArrayList<MemberPlay> memberPlays = new ArrayList<MemberPlay>();
		
		if (memberPlay1 != null){
			MemberPlay memberPlay;
			for (int i = 0; i< memberPlay1.length  ; i++){
				if (memberPlay1[i] == AppConstants.InputType.USER_INPUT_PLAY_FIEID ) continue;
				memberPlay = new MemberPlay();
				memberPlay.setMemberNo(user.getMemberNo());
				memberPlay.setPlayFieldNo(memberPlay1[i]);
				for (PlayField field : playFieldList){
					if (field.getPlayFieldNo() == memberPlay1[i]){
						memberPlay.setPlayFieldName(field.getPlayFieldName());
						break;
					}
				}
				memberPlays.add(memberPlay);
			}
		}
		
		if (memberPlay2 != null){
			MemberPlay memberPlay;
			for (int i =0; i < memberPlay2.length; i++){
				if ("".equals(memberPlay2[i]) || memberPlay2[i]== null) continue;
				memberPlay = new MemberPlay();
				memberPlay.setMemberNo(user.getMemberNo());
				memberPlay.setPlayFieldNo(AppConstants.InputType.USER_INPUT_PLAY_FIEID);
				memberPlay.setPlayFieldName(memberPlay2[i]);
				memberPlays.add(memberPlay);
			}
		}

		for (MemberPlay memberPlay : memberPlays){
			memberPlayService.insertMemberPlay(memberPlay);
		}
		
		for (MemberField memberField : memberFields){
			memberFieldSerivce.insertMemberField(memberField);
		}
		
		mailService.sendAuthenticateMail(user);
		ForwardingMessage message = prepareForwardingMessage(ForwardingMessageType.JOIN_SUCCESS);
		attr.addFlashAttribute("message", message);
		return  UserRedirect.ACTION_RESULT;
	}
			

	
	@RequestMapping(value = "/join_step4", method = RequestMethod.GET)
	public String joincompleted(RedirectAttributes attr) {	
		return UserForward.JOIN_STEP4_VIEW;
	}
	
	/** 
	 * 회원 가입 수점 폼 요청을 처리 
	 * @param model 회원 정보를 담을 모델 맵 
	 * @return
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String updateForm(ModelMap model) {
		
		LoginInfo loginInfo = loginInfoProvider.get();
		
		ProfileCommand profileCommand = userService.getProfile(loginInfo.getCurrentUser().getMemberNo());
		profileCommand.setProfileWebPath("/music/profile/" + String.valueOf(loginInfo.getCurrentUser().getMemberNo()) + 
				"/" +  profileCommand.getUser().getMemberImage());
		model.addAttribute("contries", prepareContries());
		model.addAttribute("playFields", preparePlayFields());
		model.addAttribute("activities",prepareActivities());
		model.addAttribute("profileCommand", profileCommand);
		return UserForward.PROFILE_VIEW;
	}

	/**
	 * 회원 정보 업데이트 요청을 처리 
	 * @param user 회원이 수정폼에서 입력한 정보가 담겨 있는 오브젝트 
	 * @param result 바인딩 및 검증 결과를 담고 있는 오브젝트 
	 * @return
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String update(
						@ModelAttribute("profileCommand") ProfileCommand profileCommand, 
						BindingResult result,
						ModelMap model,
						RedirectAttributes rAttr) {
		if (result.hasErrors()) {
			model.addAttribute("contries", prepareContries());
			model.addAttribute("playFields", preparePlayFields());
			model.addAttribute("activities",prepareActivities());
			return UserForward.PROFILE_VIEW;
		}
		
		userService.updateProfile(profileCommand);
		ForwardingMessage message = prepareForwardingMessage(ForwardingMessageType.PROFILE_UPDATE_SUCCESS);
		rAttr.addFlashAttribute("message",message);
		return UserRedirect.ACTION_RESULT;
	}
	
	@RequestMapping(value = "/updateSuccess", method = RequestMethod.GET)
	public String updateSuccess (ModelMap model) {
		return UserForward.UPDATE_SUCCESS_VIEW;
	}
	
	@RequestMapping(value = "/searchPage", method = RequestMethod.GET)
	public String showSearchPage(@RequestParam("type") int type, ModelMap model) {
		ForwardingMessage message = null;
		MailSendRequest mailSendRequest = new MailSendRequest();
		mailSendRequest.setType(type);
		
		switch(mailSendRequest.getType()){
		case MailSendRequest.SEND_ID_MAIL:
			message = prepareForwardingMessage(ForwardingMessageType.SEARCH_ID);
			break;
		case MailSendRequest.SEND_PASS_MAIL:
			message = prepareForwardingMessage(ForwardingMessageType.SEARCH_PASSWORD);
			break;
		}
		
		model.addAttribute("message", message);
		model.addAttribute("mailSendRequest", mailSendRequest);
		return UserForward.SEARCH_PAGE_VIEW;
	}
	
	
	@RequestMapping(value = "/searchPage", method = RequestMethod.POST)
	public String searchProcess(
			@ModelAttribute("mailSendRequest") MailSendRequest sRequest, 
			ModelMap model,
			RedirectAttributes flashAttr,
			SessionStatus status) {
		
		boolean sessionComplete = false;
		
		String returnPath =null;
		ForwardingMessage message = null;
		User user = userService.getUserByEmail(sRequest.getEmail());
		
		switch(sRequest.getType()){
		case MailSendRequest.SEND_ID_MAIL:
			if (user == null){
				message = prepareForwardingMessage(ForwardingMessageType.NOT_REGISTERED_EMAIL);
				returnPath = UserForward.SEARCH_PAGE_VIEW;
				model.addAttribute("message", message);
				return returnPath;
			}else {
				mailService.sendIdMail(user);
				message = prepareForwardingMessage(ForwardingMessageType.SEND_ID_MAIL);
				sessionComplete = true;
				returnPath = UserRedirect.SEARCH_RESULT;
	
			}
			
			break;
		case MailSendRequest.SEND_PASS_MAIL:
			if (user == null){
				message =prepareForwardingMessage(ForwardingMessageType.NOT_REGISTERED_EMAIL);
				returnPath = UserForward.SEARCH_PAGE_VIEW;
				model.addAttribute("message", message);
				return returnPath;
				
			}else {
				mailService.sendPassMail(user);
				sessionComplete = true;
				message = prepareForwardingMessage(ForwardingMessageType.SEND_PASSWORD_MAIL);
				returnPath = UserRedirect.SEARCH_RESULT;
				model.addAttribute("message", message);
			}
		}
		
		if (sessionComplete == true) status.setComplete();
		flashAttr.addFlashAttribute("message",  message);
		return returnPath;
	}
	
	/**
	 * 아이디 비번에 대한 메일 발송 요청루 결과 처리 컨트롤러  
	 * @param email 유저가 입력한 이메일 
	 * @return 
	 */
	@RequestMapping(value = "/searchResult", method = RequestMethod.GET)
	public String searchResult() {
		return UserForward.SEARCH_RESULT_VIEW;
	}
	
	/**
	 * 사용자가 인증 메일 링크를 클릭할 경우 처리하는 컨트롤러
	 */
	@RequestMapping(value ="/emailAuthenticateProcess", method = RequestMethod.GET)
	public String emailAuthenticateProcess( @RequestParam("key") String key,
			RedirectAttributes attr){
		System.out.println("=============================> emailAuthenticateProcess start");
		
		Authentication authentication = new Authentication();
		String authenticateResult;

		authentication.setAuthenticateKey(key);
		authentication = mailService.isAuthentication(authentication);
		authenticateResult = authentication.getAuthenticateResult();
		
		System.out.println("=============================> AuthenticateResult:" + authenticateResult);
		System.out.println("=============================> AuthenticateNo:" + authentication.getAuthenticateNo());
	
		ForwardingMessage message = null;
		// 회원가입 인증
		if ( AppConstants.AuthenticateType.MEMBER_JOIN.equals(authentication.getAuthenticateType()) ) {
			// 인증성공일 경우 처리
			if ( authenticateResult.equals(AppConstants.AuthenticateResult.SUCCESS) ) {
				User user = userService.getUserByEmail(authentication.getMemberUserId());
				
				/*인증실패*/
				if (user == null) {
					attr.addFlashAttribute("message", prepareForwardingMessage(ForwardingMessageType.FAIL_EMAIL_AUTH));
					return UserRedirect.AUTHENTICATE_BY_MAILL_FAIL;
				}
				/*인증성공 처리*/ 
				user.setMemberStatus(AppConstants.UserStatus.CONFIRM_JOIN);
				userService.updateUser(user);
				mailService.deleteAuthentication(authentication.getAuthenticateNo());
				attr.addFlashAttribute("message", prepareForwardingMessage(ForwardingMessageType.SUCCESS_EMAIL_AUTH));
				return UserRedirect.AUTHENTICATE_BY_MAILL_SUCCESS;
				
			// 인증실패일 경우 처리
			} else {
				return "";
			}
		// 비밀번호변경 인증
		} else {
			// 인증성공일 경우 처리
			if ( authenticateResult.equals(AppConstants.AuthenticateResult.SUCCESS) ) {
				attr.addFlashAttribute("message",prepareForwardingMessage(ForwardingMessageType.SUCCESS_PASSWORD_AUTH));
				return UserRedirect.AUTHENTICATE_BY_MAILL_SUCCESS;
			// 인증실패일 경우 처리
			} else {
				attr.addFlashAttribute("message", prepareForwardingMessage(ForwardingMessageType.FAIL_PASSWORD_AUTH));
				return UserRedirect.AUTHENTICATE_BY_MAILL_FAIL;
			}
		}
	}
	
	/**
	 * 이메일 인증을 위한 메일 입력폼을 보여준다. 
	 */
	@RequestMapping(value = "/emailAuthenticate", method = RequestMethod.GET)
	public String showEmailAuthenticateForm(
			ModelMap model) {
		MailSendRequest mailSendRequest = new MailSendRequest();
		mailSendRequest.setType(MailSendRequest.SEND_ID_MAIL);
		model.addAttribute("mailSendRequest", mailSendRequest);
		model.addAttribute("message",prepareForwardingMessage(ForwardingMessageType.BEFORE_EMAIL_AUTHENTICATE));
		return UserForward.EMAIL_AUTHENTICATE_FORM_VIEW;
	}
	
	/**
	 * 입력한 이메일로 인증 메일 발송 
	 */
	@RequestMapping(value = "/emailAuthenticate", method = RequestMethod.POST)
	public String emailAuthenticate(
			@ModelAttribute("mailSendRequest") MailSendRequest mailSendRequest,
			ModelMap model) {
		ForwardingMessage message = null;
		if (!CommonUtils.checkFormatMail(mailSendRequest.getEmail())){
			model.addAttribute("message", prepareForwardingMessage(ForwardingMessageType.INVALID_MAIL));
			return UserForward.EMAIL_AUTHENTICATE_FORM_VIEW;
		}
		User user = userService.findUser(mailSendRequest.getEmail());
		if (user == null){
			model.addAttribute("message", prepareForwardingMessage(ForwardingMessageType.NOT_REGISTERED_EMAIL));
			return UserForward.EMAIL_AUTHENTICATE_FORM_VIEW;
		}
		mailService.sendAuthenticatingMail(user);
		return UserRedirect.SEND_AUTHENTICATE_MAIL_SUCCESS;
	}
	
	/**
	 * 발송 성공 화면을 보여준다 
	 */
	@RequestMapping(value ="/sendAuthenticateMailSuccess", method = RequestMethod.GET)
	public String sendAuthenticateMaillSucces(){
		return UserForward.SEND_AUTHENTICATE_MAIL_SUCCESS_VIEW;
	}

	/**
	 * 이메일 인증 성공 페이지를 보여준다.
	 */
	@RequestMapping(value ="/authenticateMaillSuccess", method = RequestMethod.GET)
	public String authenticateMaillSuccess(){
		return UserForward.AUTHENTICATE_MAIL_SUCCESS_VIEW;
	}	
	
	/**
	 * 회원의 아이디인 이메일 중복 여부를 처리 
	 * 해당 메서드는 요청 미디어 타입에 따라 일반 jsp 뷰와 json으로 결과 반환
	 * @param email
	 * @return 중복여부를 담고 있는 json 데이타
	 */
	@ResponseBody
	@RequestMapping(value = "/emailDuplicate", method = RequestMethod.GET)
	public DuplicateResponse isEmailDuplicate(@RequestParam("email") String email) {
		return userService.isEmailDuplicate(email);
	}
	
	/**
	 * 이름 중복 여부를 처리함(이름 중복 여부 검사가 필요치 않을 때 해당 라우트를 제거) 
	 * 해당 메서드는 요청 미디어 타입에 따라 일반 jsp 뷰와 json으로 결과 반환하게 한다
	 * @param email
	 * @return 중복여부를 담고 있는 json 데이타 
	 */
	@ResponseBody
	@RequestMapping(value = "/nameDuplicate", method = RequestMethod.GET)
	public DuplicateResponse nameDuplicate(@RequestParam("name") String name) {
		return userService.isNameDuplicate(name);
	}
	
	/**
	 * 닉네임 중복 여부 요청을 처리함
	 * 해당 메서드는 요청 미디어 타입에 따라 일반 jsp 뷰와 json으로 결과를 반환
	 * @param email
	 * @return 중복여부를 담고 있는 json 데이타
	 */
	@ResponseBody
	@RequestMapping(value = "/nickDuplicate", method = RequestMethod.GET)
	public DuplicateResponse isNickDuplicate(@RequestParam("nickName") String nickName) {
		LoginInfo loginInfo = loginInfoProvider.get();
		DuplicateResponse request = null;
		User user = loginInfo.getCurrentUser();
		
		/*		
		 * 수정화면의 사용자의 닉네임이 표시되기 때문에, 전송된 닉네임이 현재 사용자의 닉네임과 일치하는 경우는
		 *	사용 가능 처리를 한다.
		 */
		if (user !=null){
			if (user.getMemberNickName().equals(nickName)){
				request = new DuplicateResponse();
				request.setResultCode(1);
				request.setValue(nickName);
				request.setDuplicate(false);
				return request;
			}
		}
		return userService.isNickNameDuplicate(nickName);
	}
	
	/**
	 * 해당 아이디가 사용가능 상태인지, 인증전인지 판단한다.
	 * @param user
	 * @return
	 */
	public boolean isBeforeAuthenticate(User user){
		return user.getMemberStatus().equals(AppConstants.UserStatus.BEFORE_AUTHENTICATE);
	}
	

}
