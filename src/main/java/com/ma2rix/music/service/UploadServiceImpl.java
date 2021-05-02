package com.ma2rix.music.service;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ma2rix.music.audio.SoundRegister;
import com.ma2rix.music.manager.AppConstants;
import com.ma2rix.music.manager.Ma2rixFileManger;
import com.ma2rix.music.model.command.ArrangementCommand;
import com.ma2rix.music.model.command.CompositionCommand;
import com.ma2rix.music.model.domain.Arrangement;
import com.ma2rix.music.model.domain.AttachMusic;
import com.ma2rix.music.model.domain.Composition;
import com.ma2rix.music.model.domain.User;
import com.ma2rix.music.service.interfaces.ArrangementService;
import com.ma2rix.music.service.interfaces.AttachMusicService;
import com.ma2rix.music.service.interfaces.CompositionService;
import com.ma2rix.music.service.interfaces.UploadService;
import com.ma2rix.music.service.interfaces.UserService;

@Service
public class UploadServiceImpl implements UploadService {

	/*파일 관련 처리를 한 후, 기존 파일 및 해당 파일을 제거하는 액션 상수*/
	private static final int DELETE_FILE = 1;
	private static final int DELETE_ALL_EXCEPT_FILE = 2;
	
	@Autowired private UserService userSerivce;
	@Autowired private ServletContext servletContext;
	@Autowired private AttachMusicService attachMusicService;
	@Autowired private ArrangementService arrangementService;
	@Autowired private Ma2rixFileManger ma2FileManger;
	@Autowired private CompositionService compositionService;
	
	@PostConstruct
	public void initUploadSystem( ){}
	
	@Override
	public void uploadProfile(int memberNo, MultipartFile mFile) throws Exception {
		UploadType type = UploadType.PROFILE_IMAGE;
		User user = userSerivce.getUserByMemberNo(memberNo);
		user.setMemberImage(mFile.getOriginalFilename());
		userSerivce.updateUser(user);	
		
		File dir = new File(ma2FileManger.getFileLocalTargetPathDir(type, memberNo));
		initDir(dir);
		
		String fileName = mFile.getOriginalFilename();
		String profileUploadDir =  ma2FileManger.getFileLocalTargetPathDir(type, memberNo);
		String profileTargetPath = ma2FileManger.getFileLocalTargetPath(UploadType.PROFILE_IMAGE, 
				memberNo, fileName);
		
		try {
			mFile.transferTo(new File(profileTargetPath));
			userSerivce.updateUser(user);
			postUploadImage(profileUploadDir,fileName,DELETE_ALL_EXCEPT_FILE);
			
		} catch (IllegalStateException e) {
			user.setMemberImage(null);
			userSerivce.updateUser(user);
			postUploadImage(profileUploadDir,fileName,DELETE_FILE);
			throw e;
			
		} catch (IOException e) {
		    user.setMemberImage(null);
		    userSerivce.updateUser(user);
		    postUploadImage(profileUploadDir,fileName,DELETE_FILE);
		    throw e;
		}
	}
	
	/**
	 * 이미지등의 파일을 업로드 한 후의 처리 작업을 담당
	 * @param dir             경로
	 * @param sourceName      파일 명
	 * @param removeType      파일 삭제 액션
	 */
	private void postUploadImage(String dir, String sourceName, int removeType){
		File f  = new File(dir);
		String[] fileNames = f.list();

		switch(removeType){
		case DELETE_FILE: 
			for (String fileName : fileNames){
				if (fileName.equals(sourceName)){
					deleteFile(dir, fileName);
				}
			}
			break;
		case DELETE_ALL_EXCEPT_FILE:
			for (String fileName : fileNames){
				if (!fileName.equals(sourceName)){
					deleteFile(dir,fileName);
				}
			}
			break;
		}
	}

	/*
	 * 파일 종류에 따라 업로드 , 파일 변환, 디비 처리, 처리완료후 정리작업을 실행 
	 * 업로드 디렉토리 관리 및 파일 저장 , 변환을 위해서 별도의 클래스로 작성 요구 
	 * 메서드 호출시 전달된 업로드 타입에 따라 분기
	 */
	@Override
	public void upload(int musicNo,UploadType uploadType,MultipartFile mFile) throws Exception  {
		switch (uploadType)
		{
			case ARRANGE_GUIDE_SOUND:
			case ARRANGE_IMAGE:
			case ARRANGE_EXTRA:
			case ARRANGE_SCORE:
			case ARRANGE_SOUND:	
				uploadArrange(musicNo, uploadType, mFile);
				break;
			case COMPOSE_SOUND:
			case COMPOSE_IMAGE:
			case COMPOSE_SCORE:
				uploadCompose(musicNo, uploadType, mFile);
				break;
			case VOCAL_IMAGE:
			case VOCAL_SOUND:
				uploadVocal(musicNo,uploadType, mFile);
			default:
				throw new Exception("wrong access");
		}
	}
	
	/* 
	 * 편곡 관련 파일업로드 및 데이타 베이스 처리 
	 */
	@Override
	public void uploadArrange(int musicNo,
			UploadType uploadType,
			MultipartFile mFile) throws Exception {
		
		AttachMusic attachMusic = null;
		String path = ma2FileManger.getFileLocalTargetPathDir(uploadType, musicNo);
		File file =  new File(path);
		ma2FileManger.initDir(file);
		
		String newFileName = ma2FileManger.creatNewFileName(mFile.getOriginalFilename());
		Arrangement arrangement = arrangementService.getArrangementByArrangeNo(musicNo);
		
		/* 
		 * 해당 곡의 파일 번호 :  attachNo ==0 initial upload (insert) , attchNo != 0 update
		 */
		int attachNo = 0;
		try {
			mFile.transferTo(new File(ma2FileManger.getFileLocalTargetPath(uploadType, musicNo, newFileName))); 
			switch (uploadType){
			case ARRANGE_GUIDE_SOUND:
				SoundRegister.SoundRegister(path, path, newFileName);
				attachNo = arrangement.getGuideSound();
				if (attachNo == 0){              
					attachMusic = new AttachMusic();
					attachMusic.setMusicClass(AppConstants.MusicClass.ARRANGE);
					attachMusic.setMusicNo(musicNo);
					attachMusic.setMusicStep(AppConstants.MusicStep.ARRANGE);
					attachMusic.setWebPath(ma2FileManger.getWebAccessTargetPathDir(uploadType, musicNo));
					attachMusic.setFilePath(ma2FileManger.getFileLocalTargetPathDir(uploadType, musicNo));
					attachMusic.setFileName(mFile.getOriginalFilename());
					attachMusic.setFileName2(newFileName);
					
					/*AttachMusic 테이블 insert*/
					attachMusicService.insertAttachMusic(attachMusic);
					
					/*인서트한 AttatchMusic 정보를 Arrangement Table 에 반영*/
					arrangement.setGuideSound(attachMusic.getAttachNo());
					arrangementService.updateArrangement(arrangement);
				}else {          
					attachMusic = attachMusicService.getAttachMusicByAttachNo(attachNo);
					attachMusic.setWebPath(ma2FileManger.getWebAccessTargetPathDir(uploadType, musicNo));
					attachMusic.setFilePath(ma2FileManger.getFileLocalTargetPathDir(uploadType, musicNo));
					attachMusic.setFileName(mFile.getOriginalFilename());
					attachMusic.setFileName2(newFileName);
					attachMusicService.updateAttachMusic(attachMusic);
				}
				break;

			case ARRANGE_IMAGE:
				attachNo = arrangement.getArrangeImage();
				if (attachNo == 0){
					attachMusic = new AttachMusic();
					attachMusic.setMusicClass(AppConstants.MusicClass.ARRANGE);
					attachMusic.setMusicNo(musicNo);
					attachMusic.setMusicStep(AppConstants.MusicStep.ARRANGE);
					attachMusic.setWebPath(ma2FileManger.getWebAccessTargetPathDir(uploadType, musicNo));
					attachMusic.setFilePath(ma2FileManger.getFileLocalTargetPathDir(uploadType, musicNo));
					attachMusic.setFileName(mFile.getOriginalFilename());
					attachMusic.setFileName2(newFileName);
					attachMusicService.insertAttachMusic(attachMusic);
					arrangement.setArrangeImage(attachMusic.getAttachNo());
					arrangementService.updateArrangement(arrangement);
				}else{
					attachMusic = attachMusicService.getAttachMusicByAttachNo(attachNo);
					attachMusic.setWebPath(ma2FileManger.getWebAccessTargetPathDir(uploadType, musicNo));
					attachMusic.setFilePath(ma2FileManger.getFileLocalTargetPathDir(uploadType, musicNo));
					attachMusic.setFileName(mFile.getOriginalFilename());
					attachMusic.setFileName2(newFileName);
					attachMusicService.updateAttachMusic(attachMusic);
				}
				break;
				
			case ARRANGE_EXTRA:
				attachNo = arrangement.getArrangeZip();
				if (attachNo == 0){
					attachMusic = new AttachMusic();
					attachMusic.setMusicClass(AppConstants.MusicClass.ARRANGE);
					attachMusic.setMusicNo(musicNo);
					attachMusic.setMusicStep(AppConstants.MusicStep.ARRANGE);
					attachMusic.setWebPath(ma2FileManger.getWebAccessTargetPathDir(uploadType, musicNo));
					attachMusic.setFilePath(ma2FileManger.getFileLocalTargetPathDir(uploadType, musicNo));
					attachMusic.setFileName(mFile.getOriginalFilename());
					attachMusic.setFileName2(newFileName);
					
					attachMusicService.insertAttachMusic(attachMusic);
					arrangement.setArrangeZip(attachMusic.getAttachNo());
					arrangementService.updateArrangement(arrangement);
				}else{
					attachMusic = attachMusicService.getAttachMusicByAttachNo(attachNo);
					attachMusic.setWebPath(ma2FileManger.getWebAccessTargetPathDir(uploadType, musicNo));
					attachMusic.setFilePath(ma2FileManger.getFileLocalTargetPathDir(uploadType, musicNo));
					attachMusic.setFileName(mFile.getOriginalFilename());
					attachMusic.setFileName2(newFileName);
					attachMusicService.updateAttachMusic(attachMusic);
				}
				break;
				
			case ARRANGE_SCORE:
				attachNo = arrangement.getArrangeScore();
				if (attachNo == 0){
					attachMusic = new AttachMusic();
					attachMusic.setMusicClass(AppConstants.MusicClass.ARRANGE);
					attachMusic.setMusicNo(musicNo);
					attachMusic.setMusicStep(AppConstants.MusicStep.ARRANGE);
					attachMusic.setWebPath(ma2FileManger.getWebAccessTargetPathDir(uploadType, musicNo));
					attachMusic.setFilePath(ma2FileManger.getFileLocalTargetPathDir(uploadType, musicNo));
					attachMusic.setFileName(mFile.getOriginalFilename());
					attachMusic.setFileName2(newFileName);
					attachMusicService.insertAttachMusic(attachMusic);
					
					arrangement.setArrangeScore(attachMusic.getAttachNo());
					arrangementService.updateArrangement(arrangement);
				}else{
					attachMusic = attachMusicService.getAttachMusicByAttachNo(attachNo);
					attachMusic.setWebPath(ma2FileManger.getWebAccessTargetPathDir(uploadType, musicNo));
					attachMusic.setFilePath(ma2FileManger.getFileLocalTargetPathDir(uploadType, musicNo));
					attachMusic.setFileName(mFile.getOriginalFilename());
					attachMusic.setFileName2(newFileName);
					attachMusicService.updateAttachMusic(attachMusic);
				}
				break;
			case ARRANGE_SOUND:
				SoundRegister.SoundRegister(path, path, newFileName);
				attachNo = arrangement.getArrangeSound();
				if (attachNo == 0){
					attachMusic = new AttachMusic();
					attachMusic.setMusicClass(AppConstants.MusicClass.ARRANGE);
					attachMusic.setMusicNo(musicNo);
					attachMusic.setMusicStep(AppConstants.MusicStep.ARRANGE);
					attachMusic.setWebPath(ma2FileManger.getWebAccessTargetPathDir(uploadType, musicNo));
					attachMusic.setFilePath(ma2FileManger.getFileLocalTargetPathDir(uploadType, musicNo));
					attachMusic.setFileName(mFile.getOriginalFilename());
					attachMusic.setFileName2(newFileName);
					attachMusicService.insertAttachMusic(attachMusic);
					
					arrangement.setArrangeSound(attachMusic.getAttachNo());
					arrangementService.updateArrangement(arrangement);
				}else{
					attachMusic = attachMusicService.getAttachMusicByAttachNo(attachNo);
					attachMusic.setWebPath(ma2FileManger.getWebAccessTargetPathDir(uploadType, musicNo));
					attachMusic.setFilePath(ma2FileManger.getFileLocalTargetPathDir(uploadType, musicNo));
					attachMusic.setFileName(mFile.getOriginalFilename());
					attachMusic.setFileName2(newFileName);
					attachMusicService.updateAttachMusic(attachMusic);
				}
				default:
					new Exception("wrong access");
			}
			postUploadFile(path,newFileName,DELETE_ALL_EXCEPT_FILE);
		} catch (Exception e) {
			postUploadFile(path,newFileName,DELETE_FILE);
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	/* 
	 * 작곡 관련 파일 업로드 및 데이타 베이스 처리 
	 */
	@Override
	public void uploadCompose(int musicNo, 
			UploadType uploadType,
			MultipartFile mFile) throws Exception {
		
		AttachMusic attachMusic = null;
		String path = ma2FileManger.getFileLocalTargetPathDir(uploadType, musicNo);
		File file =  new File(path);
		ma2FileManger.initDir(file);
		String newFileName = ma2FileManger.creatNewFileName(mFile.getOriginalFilename());
		Composition composition = compositionService.getCompositionByComposeNo(musicNo);
		/* 
		 * 해당 곡의 파일 번호 :  attachNo ==0 initial upload (insert) , attchNo != 0 update
		 */
		int attachNo = 0;
		try {
			mFile.transferTo(new File(ma2FileManger.getFileLocalTargetPath(uploadType, musicNo, newFileName))); 
			switch (uploadType){
			case COMPOSE_IMAGE:
				attachNo = composition.getComposeImage();
				System.out.println(">>attachNo::"+attachNo);
				if (attachNo == 0){
					attachMusic = new AttachMusic();
					attachMusic.setMusicClass(AppConstants.MusicClass.COMPOSE);
					attachMusic.setMusicNo(musicNo);
					attachMusic.setMusicStep(AppConstants.MusicStep.COMPOSE);
					attachMusic.setWebPath(ma2FileManger.getWebAccessTargetPathDir(uploadType, musicNo));
					attachMusic.setFilePath(ma2FileManger.getFileLocalTargetPathDir(uploadType, musicNo));
					attachMusic.setFileName(mFile.getOriginalFilename());
					attachMusic.setFileName2(newFileName);
					attachMusicService.insertAttachMusic(attachMusic);
					composition.setComposeImage(attachMusic.getAttachNo());
					compositionService.updateComposition(composition);
				
				}else{
					attachMusic = attachMusicService.getAttachMusicByAttachNo(attachNo);
					attachMusic.setWebPath(ma2FileManger.getWebAccessTargetPathDir(uploadType, musicNo));
					attachMusic.setFilePath(ma2FileManger.getFileLocalTargetPathDir(uploadType, musicNo));
					attachMusic.setFileName(mFile.getOriginalFilename());
					attachMusic.setFileName2(newFileName);
					attachMusicService.updateAttachMusic(attachMusic);
				}
				break;
				
			}
			postUploadFile(path,newFileName,DELETE_ALL_EXCEPT_FILE);
			
		} catch (Exception e) {
			postUploadFile(path,newFileName,DELETE_FILE);
			System.out.println(e.getMessage());
			throw e;
		}	
	}
	
	/* 
	 * 연주 관련 파일 업로드 및 데이타 베이스 처리 
	 */
	@Override
	public void uploadPerformance(int musicNo, 
			UploadType uploadType,
			MultipartFile mFile) throws Exception {
	}
	
	/* 
	 * 보컬 관련 파일 업로드 및 데이타 베이스 처리 
	 */
	@Override
	public void uploadVocal(int musicNo, 
			UploadType uploadType,
			MultipartFile mFile) throws Exception {
	}
	
	/**
	 * 파일 업로드 및 관련 디비 처리를 한후 파일 처리 작업 
	 * @param dir 삭제를 실행할 디렉토리
	 * @param file 파일
	 * @param action 파일을 삭제할 것인지, 해당 파일을 제외하고 다른 파일들을 삭제할 것인지의 액션 변수 
	 */
	private void postUploadFile(String dir, String sourceName, int removeType){
		String[] sepFileName = sourceName.split("\\.");
		String fileNameDiv = sepFileName[0];
		File f  = new File(dir);
		String[] fileNames = f.list();

		switch(removeType)
		{
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
	
	private void deleteFile(String dir, String fileName){
		File f = new File(dir + fileName);
		f.delete();
	}
	
	/**
	 * 해당 파일이나 해당 디렉토리의 파일을 모두 삭제.
	 */
	private void deleteFiles(File file) {
		if (file.isDirectory()){
			File[] files = file.listFiles();
			if (files.length != 0){
				for (File tFile : files){
					tFile.delete();
				}
			}
		}else {
			file.delete();
		}
	}
	
	/**
	 * 해당 디렉토리가 존재하는 지 여부 반환
	 */
	private boolean checkDirExist(File dir) {
		return dir.exists();
	}
	
	/**
	 * 해당 디렉토리가 존재하는 확인하고 , 존재하지 않으면 생성 
	 * @param dir
	 */
	private void initDir(File dir){
		if (!checkDirExist(dir))
			dir.mkdirs();
	}
	
	/**
	 * 파일이름을 현재 시간의 밀리 세컨드로 변경  
	 */
	private String creatNewFileName(String fileName){
		int index = fileName.lastIndexOf(".");
		String fileExt = fileName.substring(index + 1);
		Calendar cal = Calendar.getInstance();
		long timeString = cal.getTimeInMillis();
		return String.valueOf(timeString) + "." + fileExt;
	}
}
