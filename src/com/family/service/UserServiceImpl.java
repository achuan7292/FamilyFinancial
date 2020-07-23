package com.family.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.family.dao.UserMapper;
import com.family.domain.Result;
import com.family.domain.User;
import com.family.domain.UserExample;
import com.family.domain.UserExample.Criteria;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Override
	public User findOne(String username) {
		return userMapper.selectByUsername(username);
	}
	@Override
	public User findById(String uid) {
		return userMapper.selectByPrimaryKey(uid);
	}
	@Override
	public void addUser(User user) {
		userMapper.insertSelective(user);
	}
	@Override
	public void updateUser(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}
	@Override
	public void updatePassword(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}
	@Override
	public Result findMe(User user) {
		User selectByExample =  userMapper.selectByUsernameAndPassword(user);
		if(selectByExample==null){
			
			return new Result(false, "用户名或者密码错误");
		}else{
			return new Result(true, "登陆成功");
		}
	}

}
