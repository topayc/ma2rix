package com.ma2rix.music.model.domain;

import org.joda.time.DateTime;

public class Payment {
	private int payNo;
	private String payDate; 	/*YYYYMMDD*/
	private String payTime; 	/*HH@$MISS*/
	private int payMemberNo;
	private float payAmount;
	private float payFee;
	private int pgNo;
	private String payCard;
	private String patTid;
	private String payAuthcode;
	private String payResultCode;
	private String payResultMsg;
	private String payAuthDate;
	private String payAuthTime;
	private String payCancelDate;
	private String payCancelTime;
	private String payType;
	private DateTime regDateTime;
	private DateTime modDateTime;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int payNo, String payDate, String payTime, int payMemberNo,
			float payAmount, float payFee, int pgNo, String payCard,
			String patTid, String payAuthcode, String payResultCode,
			String payResultMsg, String payAuthDate, String payAuthTime,
			String payCancelDate, String payCancelTime, String payType,
			DateTime regDateTime, DateTime modDateTime) {
		super();
		this.payNo = payNo;
		this.payDate = payDate;
		this.payTime = payTime;
		this.payMemberNo = payMemberNo;
		this.payAmount = payAmount;
		this.payFee = payFee;
		this.pgNo = pgNo;
		this.payCard = payCard;
		this.patTid = patTid;
		this.payAuthcode = payAuthcode;
		this.payResultCode = payResultCode;
		this.payResultMsg = payResultMsg;
		this.payAuthDate = payAuthDate;
		this.payAuthTime = payAuthTime;
		this.payCancelDate = payCancelDate;
		this.payCancelTime = payCancelTime;
		this.payType = payType;
		this.regDateTime = regDateTime;
		this.modDateTime = modDateTime;
	}
	public int getPayNo() {
		return payNo;
	}
	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public int getPayMemberNo() {
		return payMemberNo;
	}
	public void setPayMemberNo(int payMemberNo) {
		this.payMemberNo = payMemberNo;
	}
	public float getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(float payAmount) {
		this.payAmount = payAmount;
	}
	public float getPayFee() {
		return payFee;
	}
	public void setPayFee(float payFee) {
		this.payFee = payFee;
	}
	public int getPgNo() {
		return pgNo;
	}
	public void setPgNo(int pgNo) {
		this.pgNo = pgNo;
	}
	public String getPayCard() {
		return payCard;
	}
	public void setPayCard(String payCard) {
		this.payCard = payCard;
	}
	public String getPatTid() {
		return patTid;
	}
	public void setPatTid(String patTid) {
		this.patTid = patTid;
	}
	public String getPayAuthcode() {
		return payAuthcode;
	}
	public void setPayAuthcode(String payAuthcode) {
		this.payAuthcode = payAuthcode;
	}
	public String getPayResultCode() {
		return payResultCode;
	}
	public void setPayResultCode(String payResultCode) {
		this.payResultCode = payResultCode;
	}
	public String getPayResultMsg() {
		return payResultMsg;
	}
	public void setPayResultMsg(String payResultMsg) {
		this.payResultMsg = payResultMsg;
	}
	public String getPayAuthDate() {
		return payAuthDate;
	}
	public void setPayAuthDate(String payAuthDate) {
		this.payAuthDate = payAuthDate;
	}
	public String getPayAuthTime() {
		return payAuthTime;
	}
	public void setPayAuthTime(String payAuthTime) {
		this.payAuthTime = payAuthTime;
	}
	public String getPayCancelDate() {
		return payCancelDate;
	}
	public void setPayCancelDate(String payCancelDate) {
		this.payCancelDate = payCancelDate;
	}
	public String getPayCancelTime() {
		return payCancelTime;
	}
	public void setPayCancelTime(String payCancelTime) {
		this.payCancelTime = payCancelTime;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public DateTime getRegDateTime() {
		return regDateTime;
	}
	public void setRegDateTime(DateTime regDateTime) {
		this.regDateTime = regDateTime;
	}
	public DateTime getModDateTime() {
		return modDateTime;
	}
	public void setModDateTime(DateTime modDateTime) {
		this.modDateTime = modDateTime;
	}
	
	
}
