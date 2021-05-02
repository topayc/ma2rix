package com.ma2rix.music.service;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma2rix.music.dao.interfaces.UserDao;
import com.ma2rix.music.model.command.ProfileCommand;
import com.ma2rix.music.model.domain.MemberField;
import com.ma2rix.music.model.domain.MemberLink;
import com.ma2rix.music.model.domain.MemberPlay;
import com.ma2rix.music.model.domain.User;
import com.ma2rix.music.model.dto.ajaxresponse.DuplicateResponse;
import com.ma2rix.music.service.interfaces.CodeService;
import com.ma2rix.music.service.interfaces.MailService;
import com.ma2rix.music.service.interfaces.MemberFieldService;
import com.ma2rix.music.service.interfaces.MemberLinkService;
import com.ma2rix.music.service.interfaces.MemberPlayService;
import com.ma2rix.music.service.interfaces.PlayFieldService;
import com.ma2rix.music.service.interfaces.UserService;
import com.ma2rix.music.web.security.LoginInfo;


@Service
public class UserServiceImpl implements UserService {

	@Autowired private UserDao userDao;
	@Autowired private MailService emailService;
	@Autowired private PlayFieldService playFieldService;
	@Autowired private CodeService codeService;
	@Autowired private MailService mailService;
	@Autowired private MemberPlayService memberPlayService;
	@Autowired private MemberFieldService memberFieldSerivce;
	@Autowired private MemberLinkService memberLinkService;
	@Inject Provider<LoginInfo> loginProvider;

	@Override
	public ProfileCommand getProfile(int memberNo) {
		ProfileCommand pCommand = new ProfileCommand(
				this.getUserByMemberNo(memberNo),
				memberLinkService.getMemberLinksByMemberNo(memberNo),
				memberPlayService.getMemberPlaysByMemberNo(memberNo),
				memberFieldSerivce.getMemberFieldsByMemberNo(memberNo));
		return pCommand;
	}
	
	@Override
	public DuplicateResponse isEmailDuplicate(String email) {
		User user = userDao.getUserByEmail(email);
		DuplicateResponse req = new DuplicateResponse();
		req.setDuplicate((user == null? 
				DuplicateResponse.NOT_DUPLICATED : DuplicateResponse.DUPLICATED));
		req.setValue(email);
		req.setResultCode(1);
		return req;
	}

	@Override
	public DuplicateResponse isNickNameDuplicate(String nickName) {
		User user = userDao.GetUserByNickName(nickName);
		DuplicateResponse req = new DuplicateResponse();
		req.setDuplicate((user == null? 
				DuplicateResponse.NOT_DUPLICATED : DuplicateResponse.DUPLICATED));
		req.setValue(nickName);
		req.setResultCode(1);
		return req;
	}

	@Override
	public DuplicateResponse isNameDuplicate(String name) {
		User user = userDao.GetUserByName(name);
		DuplicateResponse req = new DuplicateResponse();
		req.setDuplicate((user == null? 
				DuplicateResponse.NOT_DUPLICATED : DuplicateResponse.DUPLICATED));
		req.setValue(name);
		req.setResultCode(1);
		return req;
	}
	
	@Override
	public void updateProfile(ProfileCommand profileCommand) {
		User user = profileCommand.getUser();
		user.setMemberImage(this.getUserByMemberNo(user.getMemberNo()).getMemberImage());
		ArrayList<MemberLink> memberlinks = profileCommand.getMemberLinks();
		ArrayList<MemberPlay> memberPlays = profileCommand.getMemberPlays();
		ArrayList<MemberField> memberFields = profileCommand.getMemberFields();
		this.updateUser(user);
		
		//유저에 등록되어 있는 MemberLink와 MemberField 를 우선 삭제
		memberFieldSerivce.deleteAllMemberFieldsByMemberNo(user.getMemberNo());
		memberLinkService.deleteAllMemberLinkByMemberNo(user.getMemberNo());
		memberPlayService.deleteAllMemberPlaysByMemberNo(user.getMemberNo());
		
		for (MemberField memberField : memberFields){
			if (memberField == null || memberField.getMusicField() == null || "".equals(memberField.getMusicField())) 
				continue;
			memberField.setMemberNo(user.getMemberNo());
			memberFieldSerivce.insertMemberField(memberField);
		}
		
		for (MemberLink memberLink : memberlinks){
			if (memberLink == null || memberLink.getMemberLink() == null || "".equals(memberLink.getMemberLink()))
				continue;
			memberLink.setMemberNo(user.getMemberNo());
			memberLinkService.insertMemberLink(memberLink);
		}

		for (MemberPlay memberPlay : memberPlays){
			if (memberPlay == null || memberPlay.getPlayFieldName() == null || "".equals(memberPlay.getPlayFieldName())) 
				continue;
			memberPlay.setMemberNo(user.getMemberNo());
			memberPlayService.insertMemberPlay(memberPlay);
		}
	}
	
	@Override
	public ArrayList<User> getAllUser() {
		return userDao.getAllUsers();
	}

	@Override
	public User findUser(String email) {
		return userDao.findUser(email);
	}

	
	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}

	@Override
	public User findUserByUserObject(User user) {
		return userDao.findUserByUserObject(user);
	}

	@Override
	public User getUserByMemberNo(int memberNo) {
		return userDao.getUserByMemberNo(memberNo);
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		return userDao.getUserByEmailAndPassword(email, password);
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}
	
}
