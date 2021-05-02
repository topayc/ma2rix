package com.ma2rix.music.service.interfaces;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.ma2rix.music.model.command.ProfileCommand;
import com.ma2rix.music.model.domain.User;
import com.ma2rix.music.model.dto.ajaxresponse.DuplicateResponse;

@Transactional
public interface UserService {
	
	public ProfileCommand getProfile(int memberNo);
	public void updateProfile(ProfileCommand profileCommand);
	public void insertUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	public ArrayList<User> getAllUser();
	public User getUserByMemberNo(int memberNo);
	public User getUserByEmailAndPassword(String email, String password);
	public User getUserByEmail(String email); 
	
	public DuplicateResponse isEmailDuplicate(String email);
	public DuplicateResponse isNickNameDuplicate(String nickName);
	public DuplicateResponse isNameDuplicate(String name);
	
	public User findUser(String email);
	public User findUserByUserObject(User user);
}
