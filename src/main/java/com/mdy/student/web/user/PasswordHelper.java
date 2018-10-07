package com.mdy.student.web.user;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Component;

import com.mdy.student.bean.User;


@Component
public class PasswordHelper {
	public void hashPassword(User user) {
		SimpleHash sh = new SimpleHash("MD5", user.getPassword(), user.getUsername(), 2);
		user.setPassword(sh.toHex());
	}
}
