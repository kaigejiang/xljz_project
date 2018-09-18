package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.mapper.UserMapper;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.UserService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Override
	public User findById(int id) {
		
		return userMapper.findById(id);
	}
	

}
