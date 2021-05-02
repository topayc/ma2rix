package com.ma2rix.music.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.UserDao;
import com.ma2rix.music.dao.mapper.UserMapper;
import com.ma2rix.music.model.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserByEmail(String email) {
		return userMapper.getUserByEmail(email);
	}
	
	@Override
	public User GetUserByNickName(String nickName) {
		return userMapper.GetUserByNickName(nickName);
	}

	@Override
	public User GetUserByName(String name) {
		return userMapper.GetUserByName(name);
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		return userMapper.getUserByEmailAndPassword(email, password);
	}

	@Override
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		 userMapper.deleteUser(user);
	}

	@Override
	public ArrayList<User> getAllUsers() {
		return userMapper.getAllUsers();
	}
	

	@Override
	public boolean isNickNameDuplicate(String nickName) {
		return false;
	}

	@Override
	public boolean isNameDuplicate(String name) {
		return false;
	}

	@Override
	public boolean isEmailDuplicate(String email) {
		return false;
	}

	@Override
	public User getUser(User user) {
		return userMapper.getUser(user);
	}

	@Override
	public User findUser(String email) {
		return userMapper.findUser(email);
	}

	@Override
	public User findUserByUserObject(User user) {
		return userMapper.findUserByUserObejct(user);
	}

	@Override
	public User findUser(int memberNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByMemberNo(int memberNo) {
		return userMapper.getUserByMemberNo(memberNo);
	}

	

	

}
