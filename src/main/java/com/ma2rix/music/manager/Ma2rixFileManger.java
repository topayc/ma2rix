package com.ma2rix.music.manager;

import java.io.File;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ma2rix.music.service.interfaces.UploadService.UploadType;


/**
 * 업로드 파일의 저장 및 웹 접근 경로 설정 클래스 
 * 차후 인코딩 및 미디엇 서버 도입시 인코딩 서버의 환경에 맞게 소스 수정이 필요
 * 
 * @author v
 *
 */
@Component
public class Ma2rixFileManger {

	/*파일 관련 처리를 한 후, 기존 파일 및 해당 파일을 제거하는 액션 상수*/
	private static final int DELETE_FILE = 1;
	private static final int DELETE_ALL_EXCEPT_FILE = 2;
	
	private String domain;
	private String serverRealPath;
	private String contextPath;
	
	/*프로필 이미지외의 음원 관련 파일의 저장 결로 템플릿 변수*/
	private String filelocalPathTemplate;
	private String fileWebPathTemplate;

	/*프로필 이미지의 저장 경로 템플릿 변수*/ 
	private String profileImageLocalPathTemplate;
	private String profileImageWebPathTemplate;

	@Autowired private ServletContext servletContext;

	@PostConstruct
	public void initUploadSystem() {
		this.domain = "";
		this.contextPath = servletContext.getContextPath();
		this.serverRealPath = servletContext.getRealPath("/");

		/*
		 * 타입별 템플릿 설정 아래의 템플릿 구조를 사용할 경우 UploadType enum 에 
		 * 의해 타입에 따라 실제 경로를 구성되고
		 * 반환됨,  이러한 템플릿은 Ma2rixFileManger 에서 사용됨
		 * 
		 * ex)
		 * 편곡 사운드의 로컬 저장 포맷과 웹 접근 URL 포맷 
		 * serverRealpath/ma2rixUpload/arrange/arrangeNo(편곡번호)/arrangeSound/1232412132.wav(음원 파일명)
		 * domain/contextPath/ma2rixUplaod/arrange/arrangeNo(편곡번호)/arrangeSound/12132213.wav(음원파일명)
		 *                                     
		 */

		this.filelocalPathTemplate = serverRealPath + "ma2rixUpload"+ File.separator + "%s" +
				File.separator + "%d" + File.separator + "%s" + File.separator + "%s";
		
		this.fileWebPathTemplate = domain + contextPath+ "/ma2rixUpload/%s/%d/%s/%s";
		
		this.profileImageLocalPathTemplate = serverRealPath + "profile"+ File.separator + 
				"%d" + File.separator + "%s";
		this.profileImageWebPathTemplate = domain + contextPath + "/profile/%d/%s";
	}

	/**
	 * 인수로 전달된 파일의 로컬 저장 경로를 반환
	 * 템플릿 변수 
	 * @param type      저장하려는 파일의 타입 상수
	 * @param targetNo  회원번호 혹은 각 단계에 속한 음원 번호 
	 * @param fileName  파일 이름 
	 * @return
	 */
	public String getFileLocalTargetPath(UploadType type, int targetNo ,String fileName) {
		if (type == UploadType.PROFILE_IMAGE) {
			return String.format(this.getProfileImageLocalPathTemplate(),targetNo , fileName);
		} else {
			return String.format(this.getFilelocalPathTemplate(),type.rootKey(), targetNo , type.pathKey(), fileName);
		}
	}
	
	/**
	 * 인수로 전달된 업로드별 로컬 파일 저장 디렉토리 반환
	 * @param type       저장하려는 파일의 타입 상수 
	 * @param targetNo   회원번호 혹은 각 단계에 속한 음원 번호 
	 */
	public String getFileLocalTargetPathDir(UploadType type, int targetNo) {
		if (type == UploadType.PROFILE_IMAGE) {
			return String.format(this.getProfileImageLocalPathTemplate(),targetNo, "").trim();
		} else {
			return String.format(this.getFilelocalPathTemplate(),type.rootKey(), targetNo, type.pathKey(),"").trim();
			
		}
	}

	/**
	 * 인수로 전달된 파일의 웹 접근 경로를 반환
	 * 템플릿 변수 
	 * @param type      저장하려는 파일의 타입 상수
	 * @param targetNo  회원번호 혹은 각 단계에 속한 음원 번호 
	 * @param fileName  파일 이름 
	 */
	public String getWebAccessTargetPath(UploadType type, int targetNo,String fileName) {
		if (type == UploadType.PROFILE_IMAGE) {
			return String.format(this.getProfileImageWebPathTemplate(),targetNo, fileName);
		} else {
			return String.format(this.getFileWebPathTemplate(), type.rootKey(),targetNo, type.pathKey(), fileName);
		}
	}
	
	/**
	 * 인수저 전달된 업로드 별 웹 디렉토리리 반환 
	 * @param type       저장하려는 파일의 타입 상수 
	 * @param targetNo   회원번호 혹은 각 단계에 속한 음원 번호 
	 */
	public String getWebAccessTargetPathDir(UploadType type, int targetNo) {
		if (type == UploadType.PROFILE_IMAGE) {
			return String.format(this.getProfileImageWebPathTemplate(),targetNo,"").trim();
		} else {
			return String.format(this.getFileWebPathTemplate(), type.rootKey(),targetNo, type.pathKey(), "").trim();
		}
	}
	
	/**
	 * 해당 디렉토리의 존재 여부 반환
	 * @param dir   디렉토리 
	 */
	public boolean checkDirExist(File dir){
		return dir.exists();
	}
	
	/**
	 * 해당 디렉토리가 없다면 디렉토리를 생성
	 * @param dir  체크할 디렉토리 
	 */
	public void initDir(File dir){
		if (!checkDirExist(dir))
			dir.mkdirs();
	}
	
	/** 인수로 전달된 파일 삭제 
	 * @param dir         디렉토리 문자열
	 * @param fileName    파일명
	 */
	private void deleteFile(String dir, String fileName){
		File f = new File(dir + fileName);
		f.delete();
	}
	
	
	/**
	 * 해당 파일이나 해당 디렉토리의 파일을 모두 삭제.
	 * @param file   삭제하고자 하는 파일이나 디렉토리 
	 */
	private void deleteFiles(File file) {
		if (file.isDirectory()){
			File[] files = file.listFiles();
			if (files.length != 0){
				for (File tFile : files){
					tFile.delete();
				}
			}
			file.delete();
		}else {
			file.delete();
		}
	}
	
	/**
	 * 파일 업로드 및 관련 디비 처리를 한후 파일 처리 작업 
	 * @param dir 삭제를 실행할 디렉토리
	 * @param file 파일
	 * @param action 파일을 삭제할 것인지, 해당 파일을 제외하고 다른 파일들을 삭제할 것인지의 액션 변수 
	 */
	private void postUploadFile(String dir, String sourceName, int removeType){
		String fileNameDiv = sourceName.split(".")[0];
		File f  = new File(dir);
		String[] fileNames = f.list();

		switch(removeType){
		case DELETE_FILE: 
			for (String fileName : fileNames){
				if (fileName.contains(fileNameDiv)){
					deleteFile(dir, fileName);
				}
			}
			break;
		case DELETE_ALL_EXCEPT_FILE:
			for (String fileName : fileNames){
				if (!fileName.contains(fileNameDiv)){
					deleteFile(dir,fileName);
				}
			}
			break;
		}
	}
	
	
	/**
	 * 파일이름을 현재 시간의 밀리 세컨드로 변경
	 * @param fileName  변경할 원본 파일명 
	 */
	public String creatNewFileName(String fileName){
		int index = fileName.lastIndexOf(".");
		String fileExt = fileName.substring(index + 1);
		Calendar cal = Calendar.getInstance();
		long timeString = cal.getTimeInMillis();
		return String.valueOf(timeString) + "." + fileExt;
	}
	
	private String getFilelocalPathTemplate() {return filelocalPathTemplate;}
	public void setFilelocalPathTemplate(String filelocalPathTemplate) {
		this.filelocalPathTemplate = filelocalPathTemplate;
	}

	private String getFileWebPathTemplate() {return fileWebPathTemplate;}
	public void setFileWebPathTemplate(String fileWebPathTemplate) {this.fileWebPathTemplate = fileWebPathTemplate;}

	private String getProfileImageLocalPathTemplate() {return profileImageLocalPathTemplate;}
	public void setProfileImageLocalPathTemplate(
			String profileImageLocalPathTemplate) {
		this.profileImageLocalPathTemplate = profileImageLocalPathTemplate;
	}

	private String getProfileImageWebPathTemplate() {return profileImageWebPathTemplate;}
	public void setProfileImageWebPathTemplate(
			String profileImageWebPathTemplate) {
		this.profileImageWebPathTemplate = profileImageWebPathTemplate;
	}
}
