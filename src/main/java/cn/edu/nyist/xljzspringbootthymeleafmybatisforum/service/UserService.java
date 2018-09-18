package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.service;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;

public interface UserService {
	@Transactional(readOnly = true)
	User find(String name, String pwd);
	
	@Transactional(readOnly = true)
	User findByUserName(String name);
	
	//注册
    //增加用户
	@Transactional
	int addUser(User user);

}
