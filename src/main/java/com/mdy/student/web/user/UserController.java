package com.mdy.student.web.user;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mdy.student.bean.User;
import com.mdy.student.exception.UserException;
import com.mdy.student.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private PasswordHelper passwordHelper;

	// 跳转到登陆界面
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	// 登陆的动作
	@RequestMapping(value = "/userLogin", method = RequestMethod.GET)
	public String userLogin(User user, Model model) {
		Subject subject = SecurityUtils.getSubject();
		System.out.println(user.getRemember());
		if (!subject.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
			if (user.getRemember() == 1) {
				token.setRememberMe(true);
			}
			try {
				subject.login(token);
			} catch (LockedAccountException lae) {
				model.addAttribute("error", "账户已被锁定,请60秒以后重试");
				return "login";
			} catch (UnknownAccountException | IncorrectCredentialsException e) {
				model.addAttribute("error", "账户/密码出错");
				return "login";
			} catch (ExcessiveAttemptsException eae) {
				model.addAttribute("error", "账户已被锁定，请60秒以后重试");
				return "login";
			}
		}
		model.addAttribute("uname", user.getUsername());
		return "redirect:/manager/addStudent";
	}

	// 跳转到注册页面
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public String registerUser(User user, Model model) {
		passwordHelper.hashPassword(user);
		try {
			userService.createUser(user);
		} catch (UserException e) {
			model.addAttribute("error", e.getMessage());
		}
		return "login";
	}
}
