package com.mdy.student.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdy.student.bean.Permissions;
import com.mdy.student.bean.Roles;
import com.mdy.student.bean.User;
import com.mdy.student.exception.UserException;
import com.mdy.student.mapper.UserMapper;




@Service
public class UserService implements com.mdy.student.service.UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	@Transactional(readOnly = true)
	public String getUserPassword(String username) {
		// TODO Auto-generated method stub
		return userMapper.getPassword(username);
	}

	@Override
	@Transactional
	public void delUser(String username) {
		// TODO Auto-generated method stub
		userMapper.delUser(username);
	}

	@Override
	@Transactional
	public void createUser(User user){
		if(userMapper.getPassword(user.getUsername())==null) {
			userMapper.createUser(user);
			Set<Roles> roles = new HashSet<>();
			Roles role1 = new Roles();
			role1.setRole("teacher");
			roles.add(role1);
			user.setRoleSet(roles);
			userMapper.setRole(user);
		}
		else {
			throw new UserException("该账户已存在！！");
		}
	}
	@Override
	@Transactional
	public void setUserRole(User roles){
		userMapper.setRole(roles);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Roles> getAllRole() {
		// TODO Auto-generated method stub
		return userMapper.getAllRole();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Permissions> getAllPermission() {
		// TODO Auto-generated method stub
		return userMapper.getAllPermission();
	}

	@Override
	@Transactional(readOnly = true)
	public User getUserRoleInfo(String name) {
		// TODO Auto-generated method stub
		return userMapper.getUserRole(name);
	}

}
