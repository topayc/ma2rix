package com.ma2rix.music.dao.interfaces;

import java.util.ArrayList;

import com.ma2rix.music.model.domain.User;

public interface UserDao {
	public User getUser(User user);
	public User findUser(String email);
	public User findUser(int memberNo);
	public User findUserByUserObject(User user);
	public User getUserByEmail(String email);
	public User GetUserByNickName(String nickName);
	public User GetUserByName(String name);
	public User getUserByMemberNo(int memberNo);
	
	
	public ArrayList<User> getAllUsers();
	public User getUserByEmailAndPassword(String email, String password);
	
	public void insertUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	
	public boolean isNickNameDuplicate(String nickName);
	public boolean isNameDuplicate(String name);
	public boolean isEmailDuplicate(String email);
}
