package com.ma2rix.music.model.dto.ajaxresponse;


/**
 * ajax 비동기 파일 업로드 결과 객체로, 업로드한 파일에 따라 각각 적절한 필드를 
 * 세팅되며, 클라이언트 측은 요청 내용에 따라 적절한 필드를 사용함.
 */
public class MusicFileUploadResponse extends AjaxResultBase{
	private String image;                /*일반 이미지 경로*/
	private String ogg;                  /*변환된 ogg 파일 경로*/ 
	private String mp3;                  /*변환된 mp3 파일 경로*/
	private String frequencyImage;       /*음원 파일로 부터 생성된 파형 이미지 경로*/
	
	public MusicFileUploadResponse() {
		super();
	}

	public MusicFileUploadResponse(int resultCode, String value, String message) {
		super(resultCode, value, message);
	}

	public MusicFileUploadResponse(String image, String ogg, String mp3,
			String frequencyImage) {
		super();
		this.image = image;
		this.ogg = ogg;
		this.mp3 = mp3;
		this.frequencyImage = frequencyImage;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getOgg() {
		return ogg;
	}

	public void setOgg(String ogg) {
		this.ogg = ogg;
	}

	public String getMp3() {
		return mp3;
	}

	public void setMp3(String mp3) {
		this.mp3 = mp3;
	}

	public String getFrequencyImage() {
		return frequencyImage;
	}

	public void setFrequencyImage(String frequencyImage) {
		this.frequencyImage = frequencyImage;
	}


	

	
	
	
	
}
