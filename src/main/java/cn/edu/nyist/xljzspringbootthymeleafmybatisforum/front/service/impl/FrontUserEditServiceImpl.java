package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.mapper.FrontUserMapper;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontUserEditService;
@Service
public class FrontUserEditServiceImpl implements FrontUserEditService {
	@Autowired
	private FrontUserMapper userMapper;
	@Override
	public int editUserInfo(User user) {
		return userMapper.update(user);
	}

}
