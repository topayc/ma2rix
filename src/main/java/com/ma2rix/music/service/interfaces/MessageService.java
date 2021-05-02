package com.ma2rix.music.service.interfaces;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.ma2rix.music.model.domain.Message;

@Transactional
public interface MessageService {
	public int getAllMessagesCount();
 	public ArrayList<Message> getAllMessages();
 	public Message getMessageByMessageNo(int messageNo);
 	public Message getMessageByMemberNo(int memberNo);
 	public Message getMessageByTalkMemberNo(int talkMeberNo);
 	public Message getMessageByMemberNoAndType(
 			int memberNo,
 			String transferTyp);
 	public Message getMessageByTalkMemberNoAndType(
 			int talkMemberNo,
 			String transferTyp);
 	public void insertMessage(Message message);
 	public void updateMessage(Message message);
 	public void setReadStatus(
 			int messageNo,
 			String readStatus);
 	public void deleteMessage(int messageNo);
 	public void deleteMessageByMemberNo(int memberNo);
 	public void deleteMessageByTalkMemberNo(int talkMemberNo);
 	
 	public void sendMessage(Message message);
 	public void sendCommonMessage(int originMessageNo, int memberNo,int talkMemberNo, String transferType, String messageType, int musicNo,
 			String messageContent, String readStatus);
 
}
