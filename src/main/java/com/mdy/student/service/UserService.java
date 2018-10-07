package com.mdy.student.service;

import java.util.List;

import com.mdy.student.bean.Permissions;
import com.mdy.student.bean.Roles;
import com.mdy.student.bean.User;

public interface UserService {
	String getUserPassword(String username);

	void delUser(String username);

	void createUser(User user);

	List<Roles> getAllRole();

	List<Permissions> getAllPermission();

	User getUserRoleInfo(String name);

	void setUserRole(User roles);
}
