package com.ma2rix.music.model.dto.ajaxresponse;


/**
 * 닉네임 , 아이디 등의 중복 체크 요청에 대한 json 응답 클래스 
 * @author v
 *
 */
public class DuplicateResponse extends AjaxResultBase {
	
	public static final boolean DUPLICATED = true;
	public static final boolean NOT_DUPLICATED = false; 
	

	private boolean duplicate;
	
	public DuplicateResponse() {}

	public boolean isDuplicate() {
		return duplicate;
	}

	public void setDuplicate(boolean duplicate) {
		this.duplicate = duplicate;
	}
}
