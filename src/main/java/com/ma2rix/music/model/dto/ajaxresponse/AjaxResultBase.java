package com.ma2rix.music.model.dto.ajaxresponse;

/**
 * 일반적인 ajax 요청에 대한 응답을 처리하기 위한 슈퍼 클래스 
 * @author v
 *
 */
public class AjaxResultBase {
	
	public static final int RESULT_FAIL = 0;
	public static final int RESULT_SUCCESS = 1;

	public int resultCode;
	private String value;
	private String message;
	
	public AjaxResultBase() {}

	public AjaxResultBase(int resultCode, String value, String message) {
		super();
		this.resultCode = resultCode;
		this.value = value;
		this.message = message;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
