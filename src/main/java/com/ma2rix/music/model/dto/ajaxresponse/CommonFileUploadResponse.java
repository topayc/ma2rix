package com.ma2rix.music.model.dto.ajaxresponse;

/**
 * 음원 파일이 아닌 일반적인 파일 업로드의 응답 객체 
 * @author v
 *
 */
public class CommonFileUploadResponse extends AjaxResultBase {
	private String profileImageWebPath;

	public String getProfileImageWebPath() {
		return profileImageWebPath;
	}

	public void setProfileImageWebPath(String profileImageWebPath) {
		this.profileImageWebPath = profileImageWebPath;
	}

	public CommonFileUploadResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommonFileUploadResponse(int resultCode, String value, String message) {
		super(resultCode, value, message);
		// TODO Auto-generated constructor stub
	}
	
}
