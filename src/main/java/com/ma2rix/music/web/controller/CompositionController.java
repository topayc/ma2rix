package com.ma2rix.music.web.controller;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ma2rix.music.common.Pagination;
import com.ma2rix.music.manager.AppConstants;
import com.ma2rix.music.manager.ForwardingMessageType;
import com.ma2rix.music.model.command.ComposeArrangeCommand;
import com.ma2rix.music.model.command.ComposeUpdateCommand;
import com.ma2rix.music.model.command.CompositionCommand;
import com.ma2rix.music.model.domain.Composition;
import com.ma2rix.music.model.domain.Genre;
import com.ma2rix.music.model.domain.PlayField;
import com.ma2rix.music.model.dto.ForwardingMessage;
import com.ma2rix.music.model.dto.MemberMessageType;
import com.ma2rix.music.model.dto.ajaxresponse.GenericResponse;
import com.ma2rix.music.service.interfaces.ArrangementService;
//import com.ma2rix.music.service.interfaces.ArrangementAndCompositionService;
import com.ma2rix.music.service.interfaces.CodeService;
import com.ma2rix.music.service.interfaces.CommentService;
import com.ma2rix.music.service.interfaces.CompositionService;
import com.ma2rix.music.service.interfaces.GenreService;
import com.ma2rix.music.service.interfaces.PlayFieldService;
import com.ma2rix.music.service.interfaces.UserService;
import com.ma2rix.music.web.controller.ArrangementController.ArrangeForward;
import com.ma2rix.music.web.validator.ArrangementUpdateValidator;

@Controller
@SessionAttributes({"composeUpdateCommand"})
@RequestMapping("/compose")
public class CompositionController extends ApplicationController{
	
	/**
	 * 요청에 대해서 Forwarding 하기 위한 내부 클래스 
	 *
	 */
	public static class CompositionForward {
		public static final String REGISTER_UPDATE_FORM 			= "compose/registerUpdateForm"; 
		public static final String COMPOSITION_LIST 				= "shared/list";
		public static final String COMPOSITION_DETAIL			    = "compose/arragneDetail";
		
	}
	
	/**
	 * 재지정(304) redirect하기 위한 내부 클래스 
	 *
	 */
	public static class CompositionRedirect{
		public static final String COMPOSITION_INDEX 				= "redirect:/compose/index";
		public static final String COMPOSITION_REGISTER_RESULT 	    = "redirect:/compose/registerResult";
		public static final String UPDATE_RESULT 					= "redirect:/compose/updateResult";
		public static final String ACTION_RESULT   					= "redirect:/user/actionResult";
	}
	
	public static ArrayList<MemberMessageType> memberMessageTypes;
	
	static {
		memberMessageTypes= new ArrayList<MemberMessageType>();
		memberMessageTypes.add(new MemberMessageType("01", "편곡 참여 요청"));
		memberMessageTypes.add(new MemberMessageType("02", "연주 참여 요청"));
		memberMessageTypes.add(new MemberMessageType("03", "보컬 참여 요청"));
		memberMessageTypes.add(new MemberMessageType("04", "일반 메세지"));
	}
	
	@Autowired private GenreService genreService;
	@Autowired private PlayFieldService playFieldService;
	@Autowired private CodeService codeService;
	@Autowired private ArrangementUpdateValidator arrangementValidaor;
	@Autowired private CommentService commentService;
	@Autowired private CompositionService compositionService;
	@Autowired private UserService userService;
	
	/**
	 * 장트테이블의 장르 리스트 반환
	 */
	public ArrayList<Genre> genre(){
		return genreService.getAllGenres();
	}
	
	/**
	 * 연주 분야 항목 리스트 반환 
	 */
	public ArrayList<PlayField> playFields(){
		return playFieldService.getAllPlayFields();
	}
	
	/**
	 * ajax 요청 처리   
	 * 전달된 page 파라미터에 따른 (등록된) 작곡 리스트를 반환한다.
	 * page 파라미터가 전달되지 않는 다면, 1로 세팅하며 1페이지에 해당하는 리스트를 반환한다.
	 */
	@ResponseBody
	@RequestMapping(value ="/remoteList", method = RequestMethod.GET)
	public GenericResponse<CompositionCommand> index(
			@RequestParam(value = "page"	, required = false, defaultValue = "1") int page,
			@RequestParam(value = "orderBy"	, required = false, defaultValue = "0") int orderBy,
			ModelMap model)
	{	
		int  composeTotalRow  = compositionService.getCompositionCount();
		Pagination pagination = new Pagination(composeTotalRow,page,CompositionService.PAGE_OFFSET);
		
		ArrayList<CompositionCommand> compositionCommandList = compositionService.
				getCompositionCommandList(pagination.getStartRow(),CompositionService.PAGE_OFFSET,orderBy);
		
		GenericResponse<CompositionCommand> gr = new GenericResponse<CompositionCommand>();
		gr.setResultCode(1);
		gr.setCurrentRowCount(compositionCommandList.size());
		gr.setMessage("success");
		gr.setTotalPage(pagination.getPageTotalCount());
		gr.setCurrentPage(page);
		gr.setTotalRow(composeTotalRow);
		gr.setObjects(compositionCommandList);
		return gr;
	}
	
	/**
	 * 해당 작곡 세부 정보 요청을 처리
	 * @param composeNo
	 * @return
	 */
	@RequestMapping(value ="/composeDetail", method = RequestMethod.GET)
	public String composeDetail(
			@RequestParam(value = "composeNo", required = true) int composeNo, 
			ModelMap model){
		model.addAttribute("composeDetail", compositionService.getCompositionCommandByComposeNo(composeNo));
		return CompositionForward.COMPOSITION_DETAIL;
	}
	
	/**
	 * 작곡의 구매가 성공할 경우 해당 메서드(URL)가 호출되며, 
	 * 초기 편곡 정보가 디비에 등록된다.
	 */
	@RequestMapping(value ="/initCompose", method = RequestMethod.POST)
	public String initCompose(){
		Composition composition = new Composition();
		/*
		 * Composition 객체를 생성 및 초기화 작업
		 * */
		compositionService.insertComposition(composition);
		return CompositionForward.REGISTER_UPDATE_FORM;
	}
	
	/**
	 * 작곡을 구매한 후, initial_register 가 수행된 후, 등록된 작곡 대하여 작업 등록이나 
	 * 수정작업시 호출되어 등록 및 수정 폼을 출력한다.
	 */
	@RequestMapping(value ="/update", method = RequestMethod.GET)
	public String showRegisterForm(
			@RequestParam("composeNo") int composeNo,
			ModelMap model){
		
		CompositionCommand compositionCommand = compositionService.getCompositionCommandByComposeNo(composeNo);
		Composition composition = compositionService.getCompositionByComposeNo(composeNo);
		ComposeUpdateCommand composeUpdateCommand = new ComposeUpdateCommand();
		
		if (compositionCommand.getOpenStatus()==null) compositionCommand.setOpenStatus("Y");
		
		ArrayList<ComposeArrangeCommand> composeArrangeCommands = compositionService.getComposeArrangeCommandsByComposeNo(composeNo);
		
		
		for (ComposeArrangeCommand pCommand : composeArrangeCommands){
			pCommand.setIsMessageSend(AppConstants.FormMessageSendingStatus.MESSAGE_SENDED);
			pCommand.setUpdateType(AppConstants.FormUpdateType.ACTION_TYPE_INIT);
		}
		
		composeUpdateCommand.setCompositionCommand(compositionCommand);
		composeUpdateCommand.setComposition(composition);
		composeUpdateCommand.setComposeArrangeCommands(composeArrangeCommands);
		
		model.addAttribute("composeUpdateCommand", composeUpdateCommand);
		model.addAttribute("genres", genreService.getAllGenres());
		model.addAttribute("playfields", playFieldService.getAllPlayFields());
		model.addAttribute("memberMessageTypes", memberMessageTypes);
		return CompositionForward.REGISTER_UPDATE_FORM;
	}
	
	/**
	 * 작곡 수정 작업 처리 
	 */
	@RequestMapping(value ="/update", method = RequestMethod.POST)
	public String register(
			@ModelAttribute("composeUpdateCommand") ComposeUpdateCommand composeUpdateCommand,
			BindingResult result, 
			SessionStatus status,
			RedirectAttributes attr){
	
		
		//System.out.println(">>getCompositionCommand.composeTitle::"+composeUpdateCommand.getComposition().getComposeNo());
		//System.out.println(">>getComposition.composeTitle::"+composeUpdateCommand.getComposition().getComposeTitle());
		System.out.println(">>getComposition.salePrice::"+composeUpdateCommand.getComposition().getSalePrice());
		System.out.println(">>getComposition.composeRate::"+composeUpdateCommand.getComposition().getComposeRate());

		compositionService.updateCompositionUpdateCommand(composeUpdateCommand);
		status.setComplete();
		ForwardingMessage message = prepareForwardingMessage(ForwardingMessageType.ARRANGE_UPDATE_SUCCESS, 
				"/music/compose/update?compseNo=" + composeUpdateCommand.getCompositionCommand().getComposeNo());
		attr.addFlashAttribute("message", message);
		return CompositionRedirect.ACTION_RESULT;
	}
	
	
	

	
	/**
	 * 편곡 리스트페이지
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(ModelMap model) {
		model.addAttribute("title", "작곡 리스트");
		return CompositionForward.COMPOSITION_LIST;
	}



	/**
	 * 일반 작곡 리스트페이지 요청 처리 
	 */
	@RequestMapping(value = "/composeList", method = RequestMethod.GET)
	public String composeList(	

			@RequestParam("listType") int listType,
			@RequestParam(value = "page" 	,   required = false   ,defaultValue = "1") int page,
			@RequestParam(value = "genreNo" ,   required = false   ,defaultValue = "0") int genreNo,
			@RequestParam(value = "orderBy" ,   required = false   ,defaultValue = "1") int orderBy,
			ModelMap model) {

		Logger logger = Logger.getLogger(CompositionController.class);

		/*초기값*/
		int arrangeTotalRow;		
		ArrayList<CompositionCommand> compositionCommandList = null;
		Pagination pagination;

		if(listType == 1){	//작곡리스트

			arrangeTotalRow = compositionService.getCompositionCount();
			pagination = new Pagination(arrangeTotalRow,page,CompositionService.PAGE_OFFSET);

			compositionCommandList = compositionService.
					getCompositionCommandList(
							pagination.getStartRow(),
							CompositionService.PAGE_OFFSET, 
							orderBy);
		}

		model.addAttribute("listTypeString", "작곡 리스트");
		model.addAttribute("listType", listType);
		model.addAttribute("page", page);
		model.addAttribute("genreNo", genreNo);
		model.addAttribute("orderBy", orderBy);
//		model.addAttribute("genreList", genre());

		String returnUrl="";

		model.addAttribute("resultList", compositionCommandList);
		returnUrl = ArrangeForward.COMPOSE_LIST;

		return returnUrl;

	}	
	

	
	/**
	 * 편곡 리스트에 대한 ajax 요청 처리  
	 * 전달된 page 파라미터에 따른 (등록된) 편곡 리스트를 반환.
	 * page 파라미터가 전달되지 않는 다면, 1로 세팅
	 * 
	 */
	@ResponseBody
	@RequestMapping(value ="/composeRemoteList", method = RequestMethod.GET)
	public GenericResponse<CompositionCommand> arrangeRemoteList(
			@RequestParam("listType") int listType,
			@RequestParam(value = "page"	, required = false, defaultValue = "1" ) int page,
			@RequestParam(value = "genreNo"	, required = false, defaultValue = "0" ) int genreNo,
			@RequestParam(value = "orderBy"	, required = false, defaultValue = "1" ) int orderBy,
			ModelMap model)
	{	

		Logger logger = Logger.getLogger(ArrangementController.class);
		
		String arrangeStatus = "00"; //작곡리스트
		int arrangeTotalRow = compositionService.getCompositionCount();		
		GenericResponse<CompositionCommand> gr = new GenericResponse<CompositionCommand>();
		Pagination pagination = new Pagination(arrangeTotalRow,page,ArrangementService.PAGE_OFFSET);
		
		ArrayList<CompositionCommand> arrangementCommandList = compositionService.
				getCompositionCommandList(pagination.getStartRow(),ArrangementService.PAGE_OFFSET,orderBy);
		
		gr.setResultCode(1);
		gr.setListType(listType);
		gr.setMessage("success");
		gr.setCurrentRowCount(arrangementCommandList.size());
		gr.setTotalPage(arrangementCommandList.size());
		gr.setCurrentPage(page);
		gr.setTotalRow(arrangeTotalRow);
		gr.setObjects(arrangementCommandList);
		return gr;
	}	
	
}



