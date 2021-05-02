package com.ma2rix.music.common.paypal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PayPalValidationError {
	private String name;
	private PayPalValidationErrorDetails[] details;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PayPalValidationErrorDetails[] getDetails() {
		return details;
	}
	public void setDetails(PayPalValidationErrorDetails[] details) {
		this.details = details;
	}
	
	public List<String> getValidationErrorList(){
		List<String> errorList = new ArrayList<String>();
		for(PayPalValidationErrorDetails dtls:details){
			errorList.add(dtls.getField() +" : "+dtls.getIssue());
		}
		return errorList;
	}
	@Override
	public String toString() {
		return "ValidationError [name=" + name + ", details="
				+ Arrays.toString(details) + "]";
	}
	
}
