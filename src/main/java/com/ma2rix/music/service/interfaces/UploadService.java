package com.ma2rix.music.service.interfaces;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Transactional
public interface UploadService {
	public static enum UploadType {
		/*
		 * 편곡 관련 업로드 파일 및 구분 
		 * */
		ARRANGE_SOUND(1, "arrange", "arrangeSound")	   				,		   /*최초 편곡 음원*/
		ARRANGE_SCORE(2 ,"arrange", "arrangeScore")					,    	   /*편곡 악보 파일*/
		ARRANGE_EXTRA(3 ,"arrange", "arrangeExtra")					,    	   /*연주자를 위한 편곡 추가 파일(zip)*/
		ARRANGE_IMAGE(4 ,"arrange", "arrangeImage")					, 	       /*편곡 이미지*/
		ARRANGE_COMPLETE_SOUND(5, "arrange", "arrangeCompletSound") 	    ,	   /*연주자 파일이 믹싱된 최종 편곡 음원*/
		ARRANGE_GUIDE_SOUND(6	, "arrange", "arrangeGuide")      		,		   /*연주자 파일이 믹싱되고, 보컬을 위한 가이드가 삽입된 최종 편곡 음원*/
		
		COMPOSE_IMAGE(7, "compose", "composeImage")					,		   /*작곡 이미지*/
		COMPOSE_SOUND(8, "compose", "composeSound")					,		   /*작곡 사운드*/
		COMPOSE_SCORE(9, "compose", "composeScore")					,		   /*작곡 악보*/
		
		VOCAL_IMAGE(10, "vocal", "vocalImage")							,		   /*보컬 이미지*/
		VOCAL_SOUND(11, "vocal", "vocalSound")							,		   /*보컬 사운드*/
		
		PERFORM_SOUND(12, "vocal", "performSound")						,		   /*편곡 사운드*/
		PROFILE_IMAGE(13, "profile" , "profile");                      	       /*프로필 이미지*/
		
		private int value;
		private String root;
		private String path;
		
		/**
		 * @param value 해당 업로드 타입을 나타내는 정수값
		 * @param root  해당 업로드 파일의 루트 저장 경로
		 * @param path  해당 업로드 파일의 세부 저장 경로 
		 */
		UploadType(int value, String root, String path){ 
			this.value = value;
			this.root = root;
			this.path = path;
		}
		
		public int intValue(){ return value;}
		public String rootKey(){ return this.root;}
		public String pathKey(){ return this.path;}
		
		public static UploadType valueOf(int value){
			switch(value)
			{
				case 1: return ARRANGE_SOUND;
				case 2: return ARRANGE_SCORE;
				case 3: return ARRANGE_EXTRA;
				case 4: return ARRANGE_IMAGE;
				case 5: return ARRANGE_COMPLETE_SOUND;
				case 6: return ARRANGE_GUIDE_SOUND;
				case 7: return COMPOSE_IMAGE;
				case 8: return COMPOSE_SOUND;
				case 9: return COMPOSE_SCORE;
				case 10: return VOCAL_IMAGE;
				case 11: return VOCAL_SOUND;
				case 12: return PERFORM_SOUND;
			}
			return null;
		}
	}

	public void uploadProfile(int memberNo, MultipartFile file) throws Exception;
	public void upload(int musicNo,UploadType uploadType, MultipartFile mFile) throws Exception;
	public void uploadCompose(int musicNo, UploadType uploadType,MultipartFile mFile)	throws Exception;
	public void uploadArrange(int musicNo, UploadType uploadType,MultipartFile mFile) throws Exception;
	public void uploadPerformance(int musicNo,UploadType uploadType,MultipartFile mFile) throws Exception;
	public void uploadVocal(int musicNo, UploadType uploadType,MultipartFile mFile) throws Exception;
}
