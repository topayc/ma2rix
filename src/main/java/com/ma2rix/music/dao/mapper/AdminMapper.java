package com.ma2rix.music.dao.mapper;

import java.util.ArrayList;

import com.ma2rix.music.model.domain.Admin;

public interface AdminMapper {
	public int getAdminCount();
	public ArrayList<Admin> getAllAdminList();
	public Admin getAdminByAdminNo(int adminNo);
	public void insertAdmin(Admin admin);
	public void deleteAdmin(int admin);
	public void updateAdmin(Admin admin);
}
