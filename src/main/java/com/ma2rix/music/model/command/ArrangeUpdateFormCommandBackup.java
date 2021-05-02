package com.ma2rix.music.model.command;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

/**
 * 폼에서 전송되어 오는 편곡에 대한 요청 정보를 바인딩 하기 위한 클래스 
 * 이 오브젝트을 통하여 편곡등록을 위한 각각의 도메인 객체를 생성함  
 * @author v
 *
 */
public class ArrangeUpdateFormCommandBackup implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int arrangeNo;
	private String arrangeTitle;
	private int genre;
	private MultipartFile guideSound;
	private MultipartFile arrangeScore;
	private MultipartFile arrangeZip;
	private MultipartFile arrangeImage;
	
	private String guideSoundPath;
	private String arrangeSoundPath;
	private String arrangeZipPath;
	private String arrangeImagePath;
	
	private String limitStatus;
	private int limitCount;
	
	private float arrangeRate;
	private float songWriterRate;
	
	private ArrayList<Integer> memberPlay1;   /*셀렉트 박스를 통하여 선택한 연주 분야*/
	private ArrayList<String> memberPlay2;    /*사용자가 직접 입력한 연주분야*/
	
	private ArrayList<Integer> performMemberNo1; /*셀렉트 박스를 통하여 추가된 연주분야에 연주자를 선택한 경우의 연주자 리스트*/ 
	private ArrayList<Integer> performMemberNo2; /*사용자가 직접 입력한 연주분야에 연주자를 선택한 경우의 연주자 리스트*/
	
	private ArrayList<Float> performRate1;  /*셀렉트 박스를 통하여 추가된 연주분야의 연주자의 배분율*/ 
	private ArrayList<Float> performRate2;  /*사용자가 직업 입력한 연주분야의 연주자의 배분율*/
 	
	private String openStatus;
	private ArrayList<Integer> vocalNo;
	private ArrayList<String> vocals;

	public void set(ArrangementCommand command) {
		this.arrangeNo = command.getArrangeNo();
		this.arrangeTitle = command.getArrangeTitle();
		this.genre = command.getGenreNo();
//		this.guideSoundPath  = command.getGuidedSoundFile();
		this.arrangeSoundPath = command.getArrangeSoundFile();
		this.arrangeZipPath = command.getArrangeZipFile();
		this.arrangeImagePath = command.getArrangeImageWeb();
			
	}

	public ArrangeUpdateFormCommandBackup() {
	}

	public ArrangeUpdateFormCommandBackup(int arrangeNo, String arrangeTitle,
			int genre, MultipartFile guideSound, MultipartFile arrangeScore,
			MultipartFile arrangeZip, MultipartFile arrangeImage,
			String guideSoundPath, String arrangeSoundPath,
			String arrangeZipPath, String arrangeImagePath, String limitStatus,
			int limitCount, float arrangeRate, float songWriterRate,
			ArrayList<Integer> memberPlay1, ArrayList<String> memberPlay2,
			ArrayList<Integer> performMemberNo1,
			ArrayList<Integer> performMemberNo2, ArrayList<Float> performRate1,
			ArrayList<Float> performRate2, String openStatus,
			ArrayList<Integer> vocalNo, ArrayList<String> vocals) {
		super();
		this.arrangeNo = arrangeNo;
		this.arrangeTitle = arrangeTitle;
		this.genre = genre;
		this.guideSound = guideSound;
		this.arrangeScore = arrangeScore;
		this.arrangeZip = arrangeZip;
		this.arrangeImage = arrangeImage;
		this.guideSoundPath = guideSoundPath;
		this.arrangeSoundPath = arrangeSoundPath;
		this.arrangeZipPath = arrangeZipPath;
		this.arrangeImagePath = arrangeImagePath;
		this.limitStatus = limitStatus;
		this.limitCount = limitCount;
		this.arrangeRate = arrangeRate;
		this.songWriterRate = songWriterRate;
		this.memberPlay1 = memberPlay1;
		this.memberPlay2 = memberPlay2;
		this.performMemberNo1 = performMemberNo1;
		this.performMemberNo2 = performMemberNo2;
		this.performRate1 = performRate1;
		this.performRate2 = performRate2;
		this.openStatus = openStatus;
		this.vocalNo = vocalNo;
		this.vocals = vocals;
	}

	public int getArrangeNo() {
		return arrangeNo;
	}

	public void setArrangeNo(int arrangeNo) {
		this.arrangeNo = arrangeNo;
	}

	public String getArrangeTitle() {
		return arrangeTitle;
	}

	public void setArrangeTitle(String arrangeTitle) {
		this.arrangeTitle = arrangeTitle;
	}

	public int getGenre() {
		return genre;
	}

	public void setGenre(int genre) {
		this.genre = genre;
	}

	public MultipartFile getGuideSound() {
		return guideSound;
	}

	public void setGuideSound(MultipartFile guideSound) {
		this.guideSound = guideSound;
	}

	public MultipartFile getArrangeScore() {
		return arrangeScore;
	}

	public void setArrangeScore(MultipartFile arrangeScore) {
		this.arrangeScore = arrangeScore;
	}

	public MultipartFile getArrangeZip() {
		return arrangeZip;
	}

	public void setArrangeZip(MultipartFile arrangeZip) {
		this.arrangeZip = arrangeZip;
	}

	public MultipartFile getArrangeImage() {
		return arrangeImage;
	}

	public void setArrangeImage(MultipartFile arrangeImage) {
		this.arrangeImage = arrangeImage;
	}

	public String getGuideSoundPath() {
		return guideSoundPath;
	}

	public void setGuideSoundPath(String guideSoundPath) {
		this.guideSoundPath = guideSoundPath;
	}

	public String getArrangeSoundPath() {
		return arrangeSoundPath;
	}

	public void setArrangeSoundPath(String arrangeSoundPath) {
		this.arrangeSoundPath = arrangeSoundPath;
	}

	public String getArrangeZipPath() {
		return arrangeZipPath;
	}

	public void setArrangeZipPath(String arrangeZipPath) {
		this.arrangeZipPath = arrangeZipPath;
	}

	public String getArrangeImagePath() {
		return arrangeImagePath;
	}

	public void setArrangeImagePath(String arrangeImagePath) {
		this.arrangeImagePath = arrangeImagePath;
	}

	public String getLimitStatus() {
		return limitStatus;
	}

	public void setLimitStatus(String limitStatus) {
		this.limitStatus = limitStatus;
	}

	public int getLimitCount() {
		return limitCount;
	}

	public void setLimitCount(int limitCount) {
		this.limitCount = limitCount;
	}

	public float getArrangeRate() {
		return arrangeRate;
	}

	public void setArrangeRate(float arrangeRate) {
		this.arrangeRate = arrangeRate;
	}

	public float getSongWriterRate() {
		return songWriterRate;
	}

	public void setSongWriterRate(float songWriterRate) {
		this.songWriterRate = songWriterRate;
	}

	public ArrayList<Integer> getMemberPlay1() {
		return memberPlay1;
	}

	public void setMemberPlay1(ArrayList<Integer> memberPlay1) {
		this.memberPlay1 = memberPlay1;
	}

	public ArrayList<String> getMemberPlay2() {
		return memberPlay2;
	}

	public void setMemberPlay2(ArrayList<String> memberPlay2) {
		this.memberPlay2 = memberPlay2;
	}

	public ArrayList<Integer> getPerformMemberNo1() {
		return performMemberNo1;
	}

	public void setPerformMemberNo1(ArrayList<Integer> performMemberNo1) {
		this.performMemberNo1 = performMemberNo1;
	}

	public ArrayList<Integer> getPerformMemberNo2() {
		return performMemberNo2;
	}

	public void setPerformMemberNo2(ArrayList<Integer> performMemberNo2) {
		this.performMemberNo2 = performMemberNo2;
	}

	public ArrayList<Float> getPerformRate1() {
		return performRate1;
	}

	public void setPerformRate1(ArrayList<Float> performRate1) {
		this.performRate1 = performRate1;
	}

	public ArrayList<Float> getPerformRate2() {
		return performRate2;
	}

	public void setPerformRate2(ArrayList<Float> performRate2) {
		this.performRate2 = performRate2;
	}

	public String getOpenStatus() {
		return openStatus;
	}

	public void setOpenStatus(String openStatus) {
		this.openStatus = openStatus;
	}

	public ArrayList<Integer> getVocalNo() {
		return vocalNo;
	}

	public void setVocalNo(ArrayList<Integer> vocalNo) {
		this.vocalNo = vocalNo;
	}

	public ArrayList<String> getVocals() {
		return vocals;
	}

	public void setVocals(ArrayList<String> vocals) {
		this.vocals = vocals;
	}	
	
	
	
}
