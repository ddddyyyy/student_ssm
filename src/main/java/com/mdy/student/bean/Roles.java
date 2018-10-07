package com.mdy.student.bean;

import java.util.HashSet;
import java.util.Set;

public class Roles {
	private String role;
	private Set<Permissions> permissionSet = new HashSet<Permissions>();

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Permissions> getPermissionSet() {
		return permissionSet;
	}

	public void setPermissionSet(Set<Permissions> permissionSet) {
		this.permissionSet = permissionSet;
	}
}
