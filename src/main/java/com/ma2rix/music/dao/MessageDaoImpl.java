package com.ma2rix.music.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.MessageDao;
import com.ma2rix.music.dao.mapper.MessageMapper;
import com.ma2rix.music.model.domain.Message;

@Repository
public class MessageDaoImpl implements MessageDao {
	@Autowired private MessageMapper messageMapper;

	@Override
	public int getMessagesCount() {
		return messageMapper.getMessagesCount();
	}

	@Override
	public ArrayList<Message> getAllMessages() {
		return messageMapper.getAllMessages();
	}

	@Override
	public Message getMessageByMessageNo(int messageNo) {
		return messageMapper.getMessageByMessageNo(messageNo);
	}

	@Override
	public Message getMessageByMemberNo(int memberNo) {
		return messageMapper.getMessageByMemberNo(memberNo);
	}

	@Override
	public Message getMessageByTalkMemberNo(int talkMeberNo) {
		return messageMapper.getMessageByTalkMemberNo(talkMeberNo);
	}

	@Override
	public Message getMessageByMemberNoAndType(int memberNo, String transferTyp) {
		return messageMapper.getMessageByMemberNoAndType(memberNo, transferTyp);
	}

	@Override
	public Message getMessageByTalkMemberNoAndType(int talkMemberNo,
			String transferTyp) {
		return messageMapper.getMessageByTalkMemberNoAndType(talkMemberNo, transferTyp);
	}

	@Override
	public void insertMessage(Message message) {
		messageMapper.insertMessage(message);
	}

	@Override
	public void updateMessage(Message message) {
		messageMapper.updateMessage(message);
	}

	@Override
	public void setReadStatus(int messageNo, String readStatus) {
		messageMapper.setReadStatus(messageNo, readStatus);
	}

	@Override
	public void deleteMessage(int messageNo) {
		messageMapper.deleteMessage(messageNo);
	}

	@Override
	public void deleteMessageByMemberNo(int memberNo) {
		messageMapper.deleteMessageByMemberNo(memberNo);
	}

	@Override
	public void deleteMessageByTalkMemberNo(int talkMemberNo) {
		messageMapper.deleteMessageByTalkMemberNo(talkMemberNo);
	}
	
}
