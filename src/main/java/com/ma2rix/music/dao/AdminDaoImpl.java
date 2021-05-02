package com.ma2rix.music.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ma2rix.music.dao.interfaces.AdminDao;
import com.ma2rix.music.dao.mapper.AdminMapper;
import com.ma2rix.music.model.domain.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired AdminMapper adminMapper;
	
	@Override
	public int getAdminCount() {
		return adminMapper.getAdminCount();
	}

	@Override
	public ArrayList<Admin> getAllAdminList() {
		return adminMapper.getAllAdminList();
	}

	@Override
	public Admin getAdminByAdminNo(int adminNo) {
		return adminMapper.getAdminByAdminNo(adminNo);
	}

	@Override
	public void insertAdmin(Admin admin) {
		adminMapper.insertAdmin(admin);
	}

	@Override
	public void deleteAdmin(int admin) {
		adminMapper.deleteAdmin(admin);
	}

	@Override
	public void updateAdmin(Admin admin) {
		adminMapper.updateAdmin(admin);
	}

}
