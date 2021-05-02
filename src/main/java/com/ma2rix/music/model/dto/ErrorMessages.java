package com.ma2rix.music.model.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 폼 입력값에 대하여 오류메시지를 담고 있는 클래스 
 * @author v
 *
 */
public class ErrorMessages {
	private List<String> messageList = new ArrayList<String>();
	
	public List<String> getMessageList() {
		return messageList;
	}

	public void add(String message) {
		this.messageList.add(message);
	}
	
	public void addList(List<String> list){
		this.messageList.addAll(list);
	}
}
