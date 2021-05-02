package com.ma2rix.music.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma2rix.music.dao.interfaces.MessageDao;
import com.ma2rix.music.model.domain.Message;
import com.ma2rix.music.service.interfaces.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired private MessageDao messageDao;
	
	@Override
	public void sendCommonMessage(int origniMessageNo, int memberNo,int talkMemberNo, String transferType, String musicType,
			int musicNo, String messageContent, String readStatus) {
		Message message = new Message(origniMessageNo, memberNo,
			talkMemberNo, musicNo, transferType,  musicType,
			musicNo, messageContent, readStatus, null);
		this.insertMessage(message);;
	}
	
	@Override
	public void sendMessage(Message message) {
		this.messageDao.insertMessage(message);
	}

	
	@Override
	public int getAllMessagesCount() {
		return messageDao.getMessagesCount();
	}

	@Override
	public ArrayList<Message> getAllMessages() {
		return messageDao.getAllMessages();
	}

	@Override
	public Message getMessageByMessageNo(int messageNo) {
		return messageDao.getMessageByMessageNo(messageNo);
	}

	@Override
	public Message getMessageByMemberNo(int memberNo) {
		return messageDao.getMessageByMemberNo(memberNo);
	}

	@Override
	public Message getMessageByTalkMemberNo(int talkMeberNo) {
		return messageDao.getMessageByTalkMemberNo(talkMeberNo);
	}

	@Override
	public Message getMessageByMemberNoAndType(int memberNo, String transferTyp) {
		return messageDao.getMessageByMemberNoAndType(memberNo, transferTyp);
	}

	@Override
	public Message getMessageByTalkMemberNoAndType(int talkMemberNo,
			String transferTyp) {
		return messageDao.getMessageByTalkMemberNoAndType(talkMemberNo, transferTyp);
	}

	@Override
	public void insertMessage(Message message) {
		messageDao.insertMessage(message);
	}

	@Override
	public void updateMessage(Message message) {
		messageDao.updateMessage(message);
	}

	@Override
	public void setReadStatus(int messageNo, String readStatus) {
		messageDao.setReadStatus(messageNo, readStatus);
	}

	@Override
	public void deleteMessage(int messageNo) {
		messageDao.deleteMessage(messageNo);
	}

	@Override
	public void deleteMessageByMemberNo(int memberNo) {
		messageDao.deleteMessageByMemberNo(memberNo);
	}

	@Override
	public void deleteMessageByTalkMemberNo(int talkMemberNo) {
		messageDao.deleteMessageByTalkMemberNo(talkMemberNo);
	}
}
