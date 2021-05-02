package com.ma2rix.music.model.domain;

import java.io.Serializable;

import org.joda.time.DateTime;

public class Genre implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int genreNo;
	private String genreName;
	private String userStaus;
	private int regMemberNo;
	//private DateTime regDateTime;
	
	public Genre() {}

	public Genre(int genreNo, String genreName, String userStaus,
			int regMemberNo) {
		super();
		this.genreNo = genreNo;
		this.genreName = genreName;
		this.userStaus = userStaus;
		this.regMemberNo = regMemberNo;
	}

	public Genre(int genreNo, String genreName, String userStaus,
			int regMemberNo, DateTime regDateTime) {
		super();
		this.genreNo = genreNo;
		this.genreName = genreName;
		this.userStaus = userStaus;
		this.regMemberNo = regMemberNo;
		//this.regDateTime = regDateTime;
	}

	public int getGenreNo() {
		return genreNo;
	}

	public void setGenreNo(int genreNo) {
		this.genreNo = genreNo;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public String getUserStaus() {
		return userStaus;
	}

	public void setUserStaus(String userStaus) {
		this.userStaus = userStaus;
	}

	public int getRegMemberNo() {
		return regMemberNo;
	}

	public void setRegMemberNo(int regMemberNo) {
		this.regMemberNo = regMemberNo;
	}

	/*public DateTime getRegDateTime() {
		return regDateTime;
	}

	public void setRegDateTime(DateTime regDateTime) {
		this.regDateTime = regDateTime;
	}
	}*/
}
