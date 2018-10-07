package com.mdy.student.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.mdy.student.bean.Permissions;
import com.mdy.student.bean.Roles;
import com.mdy.student.bean.User;
import com.mdy.student.service.UserService;



public class MyRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Override
	// 身份认证api
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token){
		SimpleAuthenticationInfo info = null;

		// 将传进来的token进行类型转化
		UsernamePasswordToken currentUser = (UsernamePasswordToken) token;
		// 获得数据库里面的账户密码
		Object password = userService.getUserPassword(currentUser.getUsername());
		if (password != null) {
			// 比对密码  第一个参数必须为Principal的Object对象，的三个参数必须是String对象的转化，而不能是Object对象
			info = new SimpleAuthenticationInfo(currentUser.getPrincipal(), password,
					ByteSource.Util.bytes(currentUser.getUsername()), this.getName());
		} else {
			throw new UnknownAccountException();
		}
		return info;
	}

	@Override
	// 授权认证api
	/*
	 * Roles 包含
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userName = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		User user = userService.getUserRoleInfo(userName);
		Set<String> role = new HashSet<>();
		Set<String> permission = new HashSet<>();
		if (user.getRoleSet() != null) {
			for (Roles r : user.getRoleSet()) {
				role.add(r.getRole());
				if (r.getPermissionSet() != null) {
					for (Permissions p : r.getPermissionSet()) {
						permission.add(p.getPermission());
					}
				}
			}
		}
		authorizationInfo.addRoles(role);
		authorizationInfo.addStringPermissions(permission);
		return authorizationInfo;
	}

}
