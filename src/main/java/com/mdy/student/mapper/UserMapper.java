package com.mdy.student.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mdy.student.bean.Permissions;
import com.mdy.student.bean.Roles;
import com.mdy.student.bean.User;



@Component
public interface UserMapper {
	
	String getPassword(String username);

	void createUser(User user);

	void delUser(String username);

	User getUserRole(String username);

	List<Roles> getAllRole();

	List<Permissions> getAllPermission();	

	void setRole(User roles);
}
