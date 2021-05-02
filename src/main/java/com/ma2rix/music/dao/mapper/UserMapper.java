package com.ma2rix.music.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ma2rix.music.model.domain.User;

public interface UserMapper {
	public User getUser(User user);
	public User findUser(String email);
	public User findUserByUserObejct(User user);
	
	public User getUserByMemberNo(int memberNo);
	public User getUserByEmail(String email);
	public User GetUserByNickName(String nickName);
	public User GetUserByName(String name);
	public ArrayList<User> getAllUsers();
	public User getUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	public void insertUser(User user);
	public void updateUser(User user);	
	public void deleteUser(User user);
	
	public void isNickNameDuplicate(String nickName);
	public void isNameDuplicate(String name);
	public void isEmailDuplicate(String email);
}
