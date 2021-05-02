package com.ma2rix.music.model.domain;

import org.joda.time.DateTime;

public class ArrangeVocal {
	private int arrangeNo;
	private int vocalMemberNo;
	private DateTime regDateTime;

	public ArrangeVocal() {
		super();
	}
	public int getArrangeNo() {
		return arrangeNo;
	}
	public void setArrangeNo(int arrangeNo) {
		this.arrangeNo = arrangeNo;
	}
	public int getVocalMemberNo() {
		return vocalMemberNo;
	}
	public void setVocalMemberNo(int vocalMemberNo) {
		this.vocalMemberNo = vocalMemberNo;
	}
	public DateTime getRegDateTime() {
		return regDateTime;
	}
	public void setRegDateTime(DateTime regDateTime) {
		this.regDateTime = regDateTime;
	}
	
}
