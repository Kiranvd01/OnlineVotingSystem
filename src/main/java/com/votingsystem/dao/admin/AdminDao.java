package com.votingsystem.dao.admin;

import java.util.List;

import com.votingsystem.model.admin.Admin;

public interface AdminDao {
	int insertAdmin(Admin admin);
	int deleteAdmin(int id);
	int updateAdmin(Admin admin);
	Admin getAdmin(int id);
	List<Admin> getAllAdmin();
}
