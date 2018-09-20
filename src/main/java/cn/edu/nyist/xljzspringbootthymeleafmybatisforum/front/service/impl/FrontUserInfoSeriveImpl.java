package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.mapper.FrontUserMapper;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontUserInfoSerive;
@Service
public class FrontUserInfoSeriveImpl implements FrontUserInfoSerive {
	@Autowired
	private FrontUserMapper userMapper;
	@Override
	public User findUserById(int id) {
		return userMapper.findById(id);
	}

}
