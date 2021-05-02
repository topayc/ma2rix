package com.ma2rix.music.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ma2rix.music.model.domain.Message;

public interface MessageMapper {
 	public int getMessagesCount();
 	public ArrayList<Message> getAllMessages();
 	public Message getMessageByMessageNo(int messageNo);
 	public Message getMessageByMemberNo(int memberNo);
 	public Message getMessageByTalkMemberNo(int talkMeberNo);
 	public Message getMessageByMemberNoAndType(
 			@Param("memberNo") int memberNo,
 			@Param("transferType") String transferTyp);
 	public Message getMessageByTalkMemberNoAndType(
 			@Param("talkMeberNo") int talkMemberNo,
 			@Param("transferType") String transferTyp);
 	
 	public void insertMessage(Message message);
 	public void updateMessage(Message message);
 	public void setReadStatus(
 			@Param("messageNo") int messageNo,
 			@Param("readStatus") String readStatus);
 	public void deleteMessage(int messageNo);
 	public void deleteMessageByMemberNo(int memberNo);
 	public void deleteMessageByTalkMemberNo(int talkMemberNo);
}
