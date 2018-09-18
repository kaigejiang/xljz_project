package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.mapper.UserMapper;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	public UserServiceImpl() {

	}

	@Override
	public User find(String name, String pwd) {

		return userMapper.findByNameAndPwd(name,pwd);
	}

	@Override
	public User findByUserName(String name) {
		
		return userMapper.findByName(name);
	}

	@Override
	public int addUser(User user) {
		
		return userMapper.add(user);
	}

	

	

	
	

}
