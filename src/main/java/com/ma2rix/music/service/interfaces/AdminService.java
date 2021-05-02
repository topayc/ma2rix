package com.ma2rix.music.service.interfaces;

import java.util.ArrayList;

import com.ma2rix.music.model.domain.Admin;

public interface AdminService {

	public int getAdminCount();
	public ArrayList<Admin> getAllAdminList();
	public Admin getAdminByAdminNo(int adminNo);
	public void insertAdmin(Admin admin);
	public void deleteAdmin(int admin);
	public void updateAdmin(Admin admin);
}
