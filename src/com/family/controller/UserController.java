package com.family.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.family.domain.Result;
import com.family.domain.User;
import com.family.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	//findUser
	@RequestMapping("user")
	public User userInfo(HttpSession session){
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findOne(name);
		session.setAttribute("user", user);
		return user;
	}
	@RequestMapping("findMe")
	public Result findMe(@RequestBody User user,HttpSession session){
		session.setAttribute("user", user);
		return userService.findMe(user);
	}
	
	@RequestMapping("register")
	public Result register(@RequestBody User user){
		user.setUid(UUID.randomUUID().toString());
		try {
			if (user.getPassword().length()<6) {
				return new Result(false, "ע��ʧ��,���벻��6λ");
			}else if(!user.getEmail().matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")){
				return new Result(false, "ע��ʧ��,�����ʽ����");
			}
			else{
				userService.addUser(user);
				return new Result(true, "ע��ɹ�");
			}
		} catch (Exception e) {
			return new Result(false, "ע��ʧ��");
		}
	}
	
	//�����û�
	@RequestMapping("updateUserInfo")
	public Result update(@RequestBody User user,HttpSession session){
		User user2 = (User) session.getAttribute("user");
		user.setUid(user2.getUid());
		try {
			userService.updateUser(user);
			User findOne = userService.findById(user.getUid());
			session.setAttribute("user", findOne);
			return new Result(true, "���³ɹ�,�����µ�½");
		} catch (Exception e) {
			return new Result(false, "����ʧ��");
		}
	}
	
	//��������
	@RequestMapping("updatePassword")
	public Result updatePassword(@RequestBody User user,HttpSession session){
		User user2 = (User) session.getAttribute("user");
		user.setUid(user2.getUid());
		try {
				userService.updatePassword(user);
				return new Result(true, "���³ɹ�,�����µ�½");
		} catch (Exception e) {
			return new Result(false, "����ʧ��");
		}
	}
	
	
}
