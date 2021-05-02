package com.ma2rix.music.model.command;

import java.io.Serializable;
import org.joda.time.DateTime;

/**
 * 댓글 리스트에 사용되는 command 클래스
 */

public class CommentCommand implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String memberUserId;						/* 회원아이디 */
	private String commentContents;						/* 댓글내용 */
	private String regDatetime;						/* 등록날짜 */
	private String webPath;								/* 웹저장경로 */
	private String filePath;							/* 로컬저장경로 */
	private String fileName;							/* 원래 파일명 */
	private String fileName2;							/* 서버 파일명 */
	private String musicClassNo;						/* 작곡01, 편곡02 */
	
	public CommentCommand(){
		super();
	}
	
	public CommentCommand(String musicClassNo,String memberUserId, String commentContents,
			String regDatetime, String webPath, String filePath, 
			String fileName, String fileName2){
		super();
		this.musicClassNo = musicClassNo;		
		this.memberUserId = memberUserId;
		this.commentContents = commentContents;
		this.regDatetime = regDatetime;
		this.webPath = webPath;
		this.filePath = filePath;
		this.fileName = fileName;
		this.fileName2 = fileName2;				
	}
	
	public String getMusicClassNo() {
		return musicClassNo;
	}
	public void setMusicClassNo(String musicClassNo) {
		this.musicClassNo = musicClassNo;
	}	
	
	public String getMemberUserId() {
		return memberUserId;
	}
	public void setMemberUserId(String memberUserId) {
		this.memberUserId = memberUserId;
	}
	public String getCommentContents() {
		return commentContents;
	}
	public void setCommentContents(String commentContents) {
		this.commentContents = commentContents;
	}
	public String getRegDatetime() {
		return regDatetime.substring(0, 16);
	}	
	public void setRegDatetime(String regDatetime) {
		this.regDatetime = regDatetime;
	}
	public String getWebPath() {
		return webPath;
	}
	public void setWebPath(String webPath) {
		this.webPath = webPath;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileName2() {
		return fileName2;
	}
	public void setFileName2(String fileName2) {
		this.fileName2 = fileName2;
	}
		
}
