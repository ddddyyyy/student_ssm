package com.mdy.student.bean;

import java.util.HashSet;
import java.util.Set;

public class User {

	private String username;
	private String password;
	private int remember;
	private Set<Roles> roleSet = new HashSet<Roles>();



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Roles> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Roles> roleSet) {
		this.roleSet = roleSet;
	}

	public int getRemember() {
		return remember;
	}

	public void setRemember(int remember) {
		this.remember = remember;
	}
}
