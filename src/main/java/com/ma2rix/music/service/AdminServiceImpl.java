package com.ma2rix.music.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma2rix.music.dao.interfaces.AdminDao;
import com.ma2rix.music.model.domain.Admin;
import com.ma2rix.music.service.interfaces.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired AdminDao adminDao;
	
	@Override
	public int getAdminCount() {
		return adminDao.getAdminCount();
	}

	@Override
	public ArrayList<Admin> getAllAdminList() {
		return adminDao.getAllAdminList();
	}

	@Override
	public Admin getAdminByAdminNo(int adminNo) {
		return adminDao.getAdminByAdminNo(adminNo);
	}

	@Override
	public void insertAdmin(Admin admin) {
		adminDao.insertAdmin(admin);
	}

	@Override
	public void deleteAdmin(int admin) {
		adminDao.deleteAdmin(admin);
	}

	@Override
	public void updateAdmin(Admin admin) {
			adminDao.updateAdmin(admin);
	}

}
