package com.ma2rix.music.dao.interfaces;

import java.util.ArrayList;


import com.ma2rix.music.model.domain.Message;

public interface MessageDao {
	public int getMessagesCount();
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
}
