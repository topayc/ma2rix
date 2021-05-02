package com.ma2rix.music.model.command;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import com.ma2rix.music.model.domain.MemberLink;

public class UserUpdateCommand  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int memberNo;
	private String memberName;
	private String memberNickName;
	
	//폼에서 전달되는 이미지를 받기 위한 필드로 사용됨 
	//비동기 업로드를 적용할 경우 사용하지 않음 
	private MultipartFile memberImage;
	
	/*
	 * 유저 수정 폼을 내려줄 때 이 필드를 사용하여 유저 이미지 패스를 세팅하여
	View 페이지에서 해당 이미지를 노출하는 용도로 사용됨.
	*/
	private String memberImagePath;

	private String countryNo;
	private String memberCity;
	private String memberIntroduce;
	
	private String memberHompage;
	private String homePageComment;
		
	private ArrayList<String> memberLinks;
	private ArrayList<String> linkComments;
	
	//회원의 활동 분야 ( 작사가, 작곡가 등의 코드값) 
	private ArrayList<String> memberFields;
	
	// 관리자가 등록한 연주 분야중 선택한 필드 리스트  
	private ArrayList<Integer> memberPlayFieldNos;
	private ArrayList<String> memberPlayFieldNames;

	
	public UserUpdateCommand() {
		memberLinks = new ArrayList<String>();
		linkComments = new ArrayList<String>();
		memberFields = new ArrayList<String>();
		memberPlayFieldNos = new ArrayList<Integer>();
		memberPlayFieldNames = new ArrayList<String>();
		
	}


	public UserUpdateCommand(int memberNo, String memberName,
			String memberNickName, MultipartFile memberImage,
			String memberImagePath, String countryNo, String memberCity,
			String memberIntroduce, String memberHompage,
			String homePageComment, ArrayList<String> memberLinks,
			ArrayList<String> linkComments, ArrayList<String> memberFields,
			ArrayList<Integer> memberPlayFieldNos,
			ArrayList<String> memberPlayFieldNames) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.memberNickName = memberNickName;
		this.memberImage = memberImage;
		this.memberImagePath = memberImagePath;
		this.countryNo = countryNo;
		this.memberCity = memberCity;
		this.memberIntroduce = memberIntroduce;
		this.memberHompage = memberHompage;
		this.homePageComment = homePageComment;
		this.memberLinks = memberLinks;
		this.linkComments = linkComments;
		this.memberFields = memberFields;
		this.memberPlayFieldNos = memberPlayFieldNos;
		this.memberPlayFieldNames = memberPlayFieldNames;
	}


	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getMemberNickName() {
		return memberNickName;
	}


	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}


	public MultipartFile getMemberImage() {
		return memberImage;
	}


	public void setMemberImage(MultipartFile memberImage) {
		this.memberImage = memberImage;
	}


	public String getMemberImagePath() {
		return memberImagePath;
	}


	public void setMemberImagePath(String memberImagePath) {
		this.memberImagePath = memberImagePath;
	}


	public String getCountryNo() {
		return countryNo;
	}


	public void setCountryNo(String countryNo) {
		this.countryNo = countryNo;
	}


	public String getMemberCity() {
		return memberCity;
	}


	public void setMemberCity(String memberCity) {
		this.memberCity = memberCity;
	}


	public String getMemberIntroduce() {
		return memberIntroduce;
	}


	public void setMemberIntroduce(String memberIntroduce) {
		this.memberIntroduce = memberIntroduce;
	}


	public String getMemberHompage() {
		return memberHompage;
	}


	public void setMemberHompage(String memberHompage) {
		this.memberHompage = memberHompage;
	}


	public String getHomePageComment() {
		return homePageComment;
	}


	public void setHomePageComment(String homePageComment) {
		this.homePageComment = homePageComment;
	}


	public ArrayList<String> getMemberLinks() {
		return memberLinks;
	}


	public void setMemberLinks(ArrayList<String> memberLinks) {
		this.memberLinks = memberLinks;
	}


	public ArrayList<String> getLinkComments() {
		return linkComments;
	}


	public void setLinkComments(ArrayList<String> linkComments) {
		this.linkComments = linkComments;
	}


	public ArrayList<String> getMemberFields() {
		return memberFields;
	}


	public void setMemberFields(ArrayList<String> memberFields) {
		this.memberFields = memberFields;
	}


	public ArrayList<Integer> getMemberPlayFieldNos() {
		return memberPlayFieldNos;
	}


	public void setMemberPlayFieldNos(ArrayList<Integer> memberPlayFieldNos) {
		this.memberPlayFieldNos = memberPlayFieldNos;
	}


	public ArrayList<String> getMemberPlayFieldNames() {
		return memberPlayFieldNames;
	}


	public void setMemberPlayFieldNames(ArrayList<String> memberPlayFieldNames) {
		this.memberPlayFieldNames = memberPlayFieldNames;
	}


	
	
	
}
